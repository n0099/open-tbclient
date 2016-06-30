package com.baidu.tieba.enterForum.view;

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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private TextView bad;
    private ViewEventCenter bfx;
    private TextView bvA;
    private com.baidu.tieba.enterForum.b.g bvB;
    private View bvn;
    private BarImageView bvw;
    private TextView bvx;
    private TextView bvy;
    private TextView bvz;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(u.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bvn = findViewById(u.g.view_root);
        this.bad = (TextView) findViewById(u.g.forum_name);
        this.bvx = (TextView) findViewById(u.g.forum_follows_count);
        this.bvy = (TextView) findViewById(u.g.forum_thread_count);
        this.bvz = (TextView) findViewById(u.g.forum_intro);
        this.bvw = (BarImageView) findViewById(u.g.forum_avatar);
        this.bvA = (TextView) findViewById(u.g.tv_add_love);
        this.bvA.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bvA.setVisibility(0);
        } else {
            this.bvA.setVisibility(8);
        }
    }

    private String gU(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bvB = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.bad.setText(gVar.getForumName());
                this.bvx.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(u.j.attention_n)) + gU(gVar.RS()));
                this.bvy.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(u.j.text_post)) + gU(gVar.getThreadNum()));
                this.bvz.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.bvw.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bfx = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfx != null) {
            if (view == this.bvA) {
                this.bfx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bvB, null, null));
            } else if (view == this) {
                this.bfx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bvB, null, null));
            }
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        av.k(this.bvn, u.f.addresslist_item_bg);
        this.bvw.invalidate();
    }
}
