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
    private ViewEventCenter aCK;
    private com.baidu.tieba.enterForum.b.d aEA;
    private BarImageView aEu;
    private TextView aEv;
    private TextView aEw;
    private TextView aEx;
    private TextView aEy;
    private TextView aEz;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hH().a(getContext(), com.baidu.tieba.w.enter_forum_recommendinfo_item, this, true);
        init();
    }

    private void init() {
        this.aEv = (TextView) findViewById(com.baidu.tieba.v.forum_name);
        this.aEw = (TextView) findViewById(com.baidu.tieba.v.forum_follows_count);
        this.aEx = (TextView) findViewById(com.baidu.tieba.v.forum_thread_count);
        this.aEy = (TextView) findViewById(com.baidu.tieba.v.forum_intro);
        this.aEu = (BarImageView) findViewById(com.baidu.tieba.v.forum_avatar);
        this.aEz = (TextView) findViewById(com.baidu.tieba.v.tv_add_love);
        this.aEz.setOnClickListener(this);
        setOnClickListener(this);
    }

    private String ex(int i) {
        return i <= 9999999 ? String.valueOf(i) : String.format("%.1fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.d dVar) {
        if (dVar != null) {
            this.aEA = dVar;
            if (dVar.getType() == 0) {
                setVisibility(0);
                this.aEv.setText(dVar.getForumName());
                this.aEw.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.attention_n)) + ex(dVar.Gy()));
                this.aEx.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.text_post)) + ex(dVar.Gz()));
                this.aEy.setText(dVar.getSlogan());
                if (!StringUtils.isNULL(dVar.getAvatar())) {
                    this.aEu.c(dVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aCK = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCK != null) {
            if (view == this.aEz) {
                this.aCK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aEA, null, null));
            } else if (view == this) {
                this.aCK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aEA, null, null));
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        this.aEu.invalidate();
    }
}
