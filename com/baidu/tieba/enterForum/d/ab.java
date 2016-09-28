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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aPL;
    private View bIR;
    private BarImageView bJa;
    private TextView bJb;
    private TextView bJc;
    private TextView bJd;
    private TextView bJe;
    private com.baidu.tieba.enterForum.b.g bJf;
    private TextView bmM;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(r.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bIR = findViewById(r.g.view_root);
        this.bmM = (TextView) findViewById(r.g.forum_name);
        this.bJb = (TextView) findViewById(r.g.forum_follows_count);
        this.bJc = (TextView) findViewById(r.g.forum_thread_count);
        this.bJd = (TextView) findViewById(r.g.forum_intro);
        this.bJa = (BarImageView) findViewById(r.g.forum_avatar);
        this.bJe = (TextView) findViewById(r.g.tv_add_love);
        this.bJe.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bJe.setVisibility(0);
        } else {
            this.bJe.setVisibility(8);
        }
    }

    private String hA(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bJf = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.bmM.setText(gVar.getForumName());
                this.bJb.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(r.j.attention_n)) + hA(gVar.XE()));
                this.bJc.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(r.j.text_post)) + hA(gVar.XF()));
                this.bJd.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.bJa.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aPL = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aPL != null) {
            if (view == this.bJe) {
                this.aPL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bJf, null, null));
            } else if (view == this) {
                this.aPL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bJf, null, null));
            }
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        av.k(this.bIR, r.f.addresslist_item_bg);
        this.bJa.invalidate();
    }
}
