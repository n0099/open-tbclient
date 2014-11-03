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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bo;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class DiscoverItemView extends LinearLayout {
    public static final int anW = com.baidu.tieba.u.icon_news_down_bar_one;
    public static final int anX = com.baidu.tieba.u.icon_news_head_new;
    TextView JN;
    String abu;
    ViewGroup anN;
    private TbImageView anO;
    private ImageView anP;
    private TextView anQ;
    private TextView anR;
    String anS;
    int anT;
    private boolean anU;
    private boolean anV;
    private int anY;
    private View.OnClickListener anZ;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public DiscoverItemView(Context context) {
        super(context);
        this.abu = null;
        this.anS = null;
        this.anT = 0;
        this.anU = false;
        this.anV = false;
        this.anY = anX;
        this.anZ = new k(this);
        init(context);
    }

    public DiscoverItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abu = null;
        this.anS = null;
        this.anT = 0;
        this.anU = false;
        this.anV = false;
        this.anY = anX;
        this.anZ = new k(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.discover_item, this, true);
        setOrientation(1);
        this.anN = (ViewGroup) findViewById(com.baidu.tieba.v.item_container);
        this.anO = (TbImageView) findViewById(com.baidu.tieba.v.item_image);
        this.anO.setSupportNoImage(false);
        this.JN = (TextView) findViewById(com.baidu.tieba.v.title);
        this.anP = (ImageView) findViewById(com.baidu.tieba.v.newIcon);
        this.anQ = (TextView) findViewById(com.baidu.tieba.v.dis_divider_bottom);
        this.anR = (TextView) findViewById(com.baidu.tieba.v.dis_divider_top);
    }

    public void setIconAutoChange(boolean z) {
        this.anO.setAutoChangeStyle(z);
    }

    public DiscoverItemView em(int i) {
        this.anT = i;
        this.anO.setAutoChangeStyle(false);
        aw.c(this.anO, this.anT);
        return this;
    }

    public DiscoverItemView eA(String str) {
        int dimension = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds60);
        this.anO.setTag(str);
        this.anO.setAutoChangeStyle(true);
        this.anO.a(str, 10, dimension, dimension, false);
        return this;
    }

    public DiscoverItemView eB(String str) {
        this.abu = str;
        return this;
    }

    public DiscoverItemView en(int i) {
        this.JN.setText(i);
        return this;
    }

    public DiscoverItemView eC(String str) {
        this.JN.setText(str);
        return this;
    }

    public DiscoverItemView eo(int i) {
        this.anY = i;
        return this;
    }

    public DiscoverItemView bw(boolean z) {
        this.anU = z;
        this.anP.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView bx(boolean z) {
        this.anV = z;
        return this;
    }

    public DiscoverItemView by(boolean z) {
        this.anR.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView bz(boolean z) {
        this.anQ.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView eD(String str) {
        this.anS = str;
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
        if (this.anT != 0) {
            aw.c(this.anO, this.anT);
        }
        this.anO.refresh();
        bo.a(this, i);
        aw.h(this, com.baidu.tieba.u.list_item_selector);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (az.aA(this.anS)) {
            this.anS = String.valueOf(this.JN.getText());
        }
        boolean z = this.anU;
        if (this.anU) {
            if (this.anY == anW) {
                aw.c(this.anP, this.anY);
            }
            if (this.anV) {
                z = !TbadkSettings.getInst().loadBoolean(com.baidu.adp.lib.util.u.aE(this.anS), false);
            }
        }
        this.anP.setVisibility(z ? 0 : 8);
        setOnClickListener(this.anZ);
    }
}
