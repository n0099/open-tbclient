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
    private ViewEventCenter bEQ;
    private View bGF;
    private BarImageView bGO;
    private TextView bGP;
    private TextView bGQ;
    private TextView bGR;
    private TextView bGS;
    private com.baidu.tieba.enterForum.b.g bGT;
    private TextView bsA;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bGF = findViewById(w.h.view_root);
        this.bsA = (TextView) findViewById(w.h.forum_name);
        this.bGP = (TextView) findViewById(w.h.forum_follows_count);
        this.bGQ = (TextView) findViewById(w.h.forum_thread_count);
        this.bGR = (TextView) findViewById(w.h.forum_intro);
        this.bGO = (BarImageView) findViewById(w.h.forum_avatar);
        this.bGS = (TextView) findViewById(w.h.tv_add_love);
        this.bGS.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bGS.setVisibility(0);
        } else {
            this.bGS.setVisibility(8);
        }
    }

    private String ht(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bGT = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.bsA.setText(gVar.getForumName());
                this.bGP.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(w.l.attention)) + ht(gVar.Vk()));
                this.bGQ.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(w.l.text_post)) + ht(gVar.Vl()));
                this.bGR.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.bGO.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bEQ = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bEQ != null) {
            if (view == this.bGS) {
                this.bEQ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bGT, null, null));
            } else if (view == this) {
                this.bEQ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bGT, null, null));
            }
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        aq.j(this.bGF, w.g.addresslist_item_bg);
        this.bGO.invalidate();
    }
}
