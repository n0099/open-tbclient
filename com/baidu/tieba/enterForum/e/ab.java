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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aXs;
    private BarImageView aZA;
    private TextView aZB;
    private TextView aZC;
    private TextView aZD;
    private TextView aZE;
    private TextView aZF;
    private com.baidu.tieba.enterForum.b.f aZG;
    private View aZr;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.aZr = findViewById(t.g.view_root);
        this.aZB = (TextView) findViewById(t.g.forum_name);
        this.aZC = (TextView) findViewById(t.g.forum_follows_count);
        this.aZD = (TextView) findViewById(t.g.forum_thread_count);
        this.aZE = (TextView) findViewById(t.g.forum_intro);
        this.aZA = (BarImageView) findViewById(t.g.forum_avatar);
        this.aZF = (TextView) findViewById(t.g.tv_add_love);
        this.aZF.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aZF.setVisibility(0);
        } else {
            this.aZF.setVisibility(8);
        }
    }

    private String fU(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.f fVar) {
        if (fVar != null) {
            this.aZG = fVar;
            if (fVar.getType() == 0) {
                setVisibility(0);
                this.aZB.setText(fVar.getForumName());
                this.aZC.setText(String.valueOf(TbadkCoreApplication.m11getInst().getString(t.j.attention_n)) + fU(fVar.Mo()));
                this.aZD.setText(String.valueOf(TbadkCoreApplication.m11getInst().getString(t.j.text_post)) + fU(fVar.getThreadNum()));
                this.aZE.setText(fVar.getSlogan());
                if (!StringUtils.isNULL(fVar.getAvatar())) {
                    this.aZA.c(fVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aXs = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aXs != null) {
            if (view == this.aZF) {
                this.aXs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aZG, null, null));
            } else if (view == this) {
                this.aXs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aZG, null, null));
            }
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        at.k(this.aZr, t.f.addresslist_item_bg);
        this.aZA.invalidate();
    }
}
