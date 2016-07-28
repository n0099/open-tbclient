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
    private TextView bbc;
    private ViewEventCenter bgJ;
    private View bxB;
    private BarImageView bxK;
    private TextView bxL;
    private TextView bxM;
    private TextView bxN;
    private TextView bxO;
    private com.baidu.tieba.enterForum.b.g bxP;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(u.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bxB = findViewById(u.g.view_root);
        this.bbc = (TextView) findViewById(u.g.forum_name);
        this.bxL = (TextView) findViewById(u.g.forum_follows_count);
        this.bxM = (TextView) findViewById(u.g.forum_thread_count);
        this.bxN = (TextView) findViewById(u.g.forum_intro);
        this.bxK = (BarImageView) findViewById(u.g.forum_avatar);
        this.bxO = (TextView) findViewById(u.g.tv_add_love);
        this.bxO.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bxO.setVisibility(0);
        } else {
            this.bxO.setVisibility(8);
        }
    }

    private String gU(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bxP = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.bbc.setText(gVar.getForumName());
                this.bxL.setText(String.valueOf(TbadkCoreApplication.m10getInst().getString(u.j.attention_n)) + gU(gVar.Sz()));
                this.bxM.setText(String.valueOf(TbadkCoreApplication.m10getInst().getString(u.j.text_post)) + gU(gVar.SA()));
                this.bxN.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.bxK.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bgJ = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bgJ != null) {
            if (view == this.bxO) {
                this.bgJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bxP, null, null));
            } else if (view == this) {
                this.bgJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bxP, null, null));
            }
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        av.k(this.bxB, u.f.addresslist_item_bg);
        this.bxK.invalidate();
    }
}
