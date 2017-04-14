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
    private ViewEventCenter bEJ;
    private BarImageView bGH;
    private TextView bGI;
    private TextView bGJ;
    private TextView bGK;
    private TextView bGL;
    private com.baidu.tieba.enterForum.b.g bGM;
    private View bGy;
    private TextView bss;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bGy = findViewById(w.h.view_root);
        this.bss = (TextView) findViewById(w.h.forum_name);
        this.bGI = (TextView) findViewById(w.h.forum_follows_count);
        this.bGJ = (TextView) findViewById(w.h.forum_thread_count);
        this.bGK = (TextView) findViewById(w.h.forum_intro);
        this.bGH = (BarImageView) findViewById(w.h.forum_avatar);
        this.bGL = (TextView) findViewById(w.h.tv_add_love);
        this.bGL.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bGL.setVisibility(0);
        } else {
            this.bGL.setVisibility(8);
        }
    }

    private String hw(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bGM = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.bss.setText(gVar.getForumName());
                this.bGI.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(w.l.attention)) + hw(gVar.VI()));
                this.bGJ.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(w.l.text_post)) + hw(gVar.VJ()));
                this.bGK.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.bGH.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bEJ = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bEJ != null) {
            if (view == this.bGL) {
                this.bEJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bGM, null, null));
            } else if (view == this) {
                this.bEJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bGM, null, null));
            }
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        aq.j(this.bGy, w.g.addresslist_item_bg);
        this.bGH.invalidate();
    }
}
