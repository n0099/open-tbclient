package com.baidu.tieba.enterForum.e;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aOw;
    private View bIQ;
    private BarImageView bIZ;
    private TextView bJa;
    private TextView bJb;
    private TextView bJc;
    private TextView bJd;
    private com.baidu.tieba.enterForum.b.g bJe;
    private TextView bmz;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bIQ = findViewById(t.g.view_root);
        this.bmz = (TextView) findViewById(t.g.forum_name);
        this.bJa = (TextView) findViewById(t.g.forum_follows_count);
        this.bJb = (TextView) findViewById(t.g.forum_thread_count);
        this.bJc = (TextView) findViewById(t.g.forum_intro);
        this.bIZ = (BarImageView) findViewById(t.g.forum_avatar);
        this.bJd = (TextView) findViewById(t.g.tv_add_love);
        this.bJd.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bJd.setVisibility(0);
        } else {
            this.bJd.setVisibility(8);
        }
    }

    private String hw(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bJe = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.bmz.setText(gVar.getForumName());
                this.bJa.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(t.j.attention_n)) + hw(gVar.Xl()));
                this.bJb.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(t.j.text_post)) + hw(gVar.Xm()));
                this.bJc.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.bIZ.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aOw = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aOw != null) {
            if (view == this.bJd) {
                this.aOw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bJe, null, null));
            } else if (view == this) {
                this.aOw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bJe, null, null));
            }
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        av.k(this.bIQ, t.f.addresslist_item_bg);
        this.bIZ.invalidate();
    }
}
