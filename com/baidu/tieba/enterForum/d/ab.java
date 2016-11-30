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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aRS;
    private View bLK;
    private BarImageView bLT;
    private TextView bLU;
    private TextView bLV;
    private TextView bLW;
    private TextView bLX;
    private com.baidu.tieba.enterForum.b.g bLY;
    private TextView bpH;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(r.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bLK = findViewById(r.g.view_root);
        this.bpH = (TextView) findViewById(r.g.forum_name);
        this.bLU = (TextView) findViewById(r.g.forum_follows_count);
        this.bLV = (TextView) findViewById(r.g.forum_thread_count);
        this.bLW = (TextView) findViewById(r.g.forum_intro);
        this.bLT = (BarImageView) findViewById(r.g.forum_avatar);
        this.bLX = (TextView) findViewById(r.g.tv_add_love);
        this.bLX.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bLX.setVisibility(0);
        } else {
            this.bLX.setVisibility(8);
        }
    }

    private String hB(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bLY = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.bpH.setText(gVar.getForumName());
                this.bLU.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(r.j.attention_n)) + hB(gVar.YG()));
                this.bLV.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(r.j.text_post)) + hB(gVar.YH()));
                this.bLW.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.bLT.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aRS = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aRS != null) {
            if (view == this.bLX) {
                this.aRS.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bLY, null, null));
            } else if (view == this) {
                this.aRS.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bLY, null, null));
            }
        }
    }

    public void r(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        at.k(this.bLK, r.f.addresslist_item_bg);
        this.bLT.invalidate();
    }
}
