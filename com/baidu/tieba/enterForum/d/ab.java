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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private TextView aNA;
    private TextView aNB;
    private TextView aNC;
    private BarImageView aNy;
    private TextView aNz;
    private ViewEventCenter aUs;
    private View aWL;
    private TextView aWU;
    private com.baidu.tieba.enterForum.b.f aWV;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(n.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.aWL = findViewById(n.g.view_root);
        this.aNz = (TextView) findViewById(n.g.forum_name);
        this.aNA = (TextView) findViewById(n.g.forum_follows_count);
        this.aNB = (TextView) findViewById(n.g.forum_thread_count);
        this.aNC = (TextView) findViewById(n.g.forum_intro);
        this.aNy = (BarImageView) findViewById(n.g.forum_avatar);
        this.aWU = (TextView) findViewById(n.g.tv_add_love);
        this.aWU.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aWU.setVisibility(0);
        } else {
            this.aWU.setVisibility(8);
        }
    }

    private String fA(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.f fVar) {
        if (fVar != null) {
            this.aWV = fVar;
            if (fVar.getType() == 0) {
                setVisibility(0);
                this.aNz.setText(fVar.getForumName());
                this.aNA.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(n.j.attention_n)) + fA(fVar.JY()));
                this.aNB.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(n.j.text_post)) + fA(fVar.JZ()));
                this.aNC.setText(fVar.getSlogan());
                if (!StringUtils.isNULL(fVar.getAvatar())) {
                    this.aNy.d(fVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aUs = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aUs != null) {
            if (view == this.aWU) {
                this.aUs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aWV, null, null));
            } else if (view == this) {
                this.aUs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aWV, null, null));
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        as.i(this.aWL, n.f.addresslist_item_bg);
        this.aNy.invalidate();
    }
}
