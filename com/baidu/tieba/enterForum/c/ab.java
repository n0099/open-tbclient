package com.baidu.tieba.enterForum.c;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter bHa;
    private View bIP;
    private BarImageView bIY;
    private TextView bIZ;
    private TextView bJa;
    private TextView bJb;
    private TextView bJc;
    private com.baidu.tieba.enterForum.b.g bJd;
    private TextView buL;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bIP = findViewById(w.h.view_root);
        this.buL = (TextView) findViewById(w.h.forum_name);
        this.bIZ = (TextView) findViewById(w.h.forum_follows_count);
        this.bJa = (TextView) findViewById(w.h.forum_thread_count);
        this.bJb = (TextView) findViewById(w.h.forum_intro);
        this.bIY = (BarImageView) findViewById(w.h.forum_avatar);
        this.bJc = (TextView) findViewById(w.h.tv_add_love);
        this.bJc.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bJc.setVisibility(0);
        } else {
            this.bJc.setVisibility(8);
        }
    }

    private String hC(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bJd = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.buL.setText(gVar.getForumName());
                this.bIZ.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(w.l.attention)) + hC(gVar.WJ()));
                this.bJa.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(w.l.text_post)) + hC(gVar.WK()));
                this.bJb.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.bIY.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bHa = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bHa != null) {
            if (view == this.bJc) {
                this.bHa.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bJd, null, null));
            } else if (view == this) {
                this.bHa.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bJd, null, null));
            }
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        aq.j(this.bIP, w.g.addresslist_item_bg);
        this.bIY.invalidate();
    }
}
