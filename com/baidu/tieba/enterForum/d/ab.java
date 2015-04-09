package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aCS;
    private BarImageView aEC;
    private TextView aED;
    private TextView aEE;
    private TextView aEF;
    private TextView aEG;
    private TextView aEH;
    private com.baidu.tieba.enterForum.b.d aEI;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hH().a(getContext(), com.baidu.tieba.w.enter_forum_recommendinfo_item, this, true);
        init();
    }

    private void init() {
        this.aED = (TextView) findViewById(com.baidu.tieba.v.forum_name);
        this.aEE = (TextView) findViewById(com.baidu.tieba.v.forum_follows_count);
        this.aEF = (TextView) findViewById(com.baidu.tieba.v.forum_thread_count);
        this.aEG = (TextView) findViewById(com.baidu.tieba.v.forum_intro);
        this.aEC = (BarImageView) findViewById(com.baidu.tieba.v.forum_avatar);
        this.aEH = (TextView) findViewById(com.baidu.tieba.v.tv_add_love);
        this.aEH.setOnClickListener(this);
        setOnClickListener(this);
    }

    private String ex(int i) {
        return i <= 9999999 ? String.valueOf(i) : String.format("%.1fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.d dVar) {
        if (dVar != null) {
            this.aEI = dVar;
            if (dVar.getType() == 0) {
                setVisibility(0);
                this.aED.setText(dVar.getForumName());
                this.aEE.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.attention_n)) + ex(dVar.GE()));
                this.aEF.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.text_post)) + ex(dVar.GF()));
                this.aEG.setText(dVar.getSlogan());
                if (!StringUtils.isNULL(dVar.getAvatar())) {
                    this.aEC.c(dVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aCS = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCS != null) {
            if (view == this.aEH) {
                this.aCS.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aEI, null, null));
            } else if (view == this) {
                this.aCS.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aEI, null, null));
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        this.aEC.invalidate();
    }
}
