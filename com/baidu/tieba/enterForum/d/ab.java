package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private BarImageView aLX;
    private TextView aLY;
    private TextView aLZ;
    private TextView aMa;
    private TextView aMb;
    private ViewEventCenter aQB;
    private View aSJ;
    private TextView aSS;
    private com.baidu.tieba.enterForum.b.f aST;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(n.g.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.aSJ = findViewById(n.f.view_root);
        this.aLY = (TextView) findViewById(n.f.forum_name);
        this.aLZ = (TextView) findViewById(n.f.forum_follows_count);
        this.aMa = (TextView) findViewById(n.f.forum_thread_count);
        this.aMb = (TextView) findViewById(n.f.forum_intro);
        this.aLX = (BarImageView) findViewById(n.f.forum_avatar);
        this.aSS = (TextView) findViewById(n.f.tv_add_love);
        this.aSS.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aSS.setVisibility(0);
        } else {
            this.aSS.setVisibility(8);
        }
    }

    private String fF(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.f fVar) {
        if (fVar != null) {
            this.aST = fVar;
            if (fVar.getType() == 0) {
                setVisibility(0);
                this.aLY.setText(fVar.getForumName());
                this.aLZ.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(n.i.attention_n)) + fF(fVar.JH()));
                this.aMa.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(n.i.text_post)) + fF(fVar.JI()));
                this.aMb.setText(fVar.getSlogan());
                if (!StringUtils.isNULL(fVar.getAvatar())) {
                    this.aLX.d(fVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aQB = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aQB != null) {
            if (view == this.aSS) {
                this.aQB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aST, null, null));
            } else if (view == this) {
                this.aQB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aST, null, null));
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        as.i(this.aSJ, n.e.addresslist_item_bg);
        this.aLX.invalidate();
    }
}
