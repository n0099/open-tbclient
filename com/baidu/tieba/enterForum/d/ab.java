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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private BarImageView aRP;
    private TextView aRQ;
    private TextView aRR;
    private TextView aRS;
    private TextView aRT;
    private ViewEventCenter bbj;
    private View bdJ;
    private TextView bdS;
    private com.baidu.tieba.enterForum.b.f bdT;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bdJ = findViewById(t.g.view_root);
        this.aRQ = (TextView) findViewById(t.g.forum_name);
        this.aRR = (TextView) findViewById(t.g.forum_follows_count);
        this.aRS = (TextView) findViewById(t.g.forum_thread_count);
        this.aRT = (TextView) findViewById(t.g.forum_intro);
        this.aRP = (BarImageView) findViewById(t.g.forum_avatar);
        this.bdS = (TextView) findViewById(t.g.tv_add_love);
        this.bdS.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bdS.setVisibility(0);
        } else {
            this.bdS.setVisibility(8);
        }
    }

    private String gp(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.f fVar) {
        if (fVar != null) {
            this.bdT = fVar;
            if (fVar.getType() == 0) {
                setVisibility(0);
                this.aRQ.setText(fVar.getForumName());
                this.aRR.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(t.j.attention_n)) + gp(fVar.ND()));
                this.aRS.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(t.j.text_post)) + gp(fVar.NE()));
                this.aRT.setText(fVar.getSlogan());
                if (!StringUtils.isNULL(fVar.getAvatar())) {
                    this.aRP.c(fVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bbj = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbj != null) {
            if (view == this.bdS) {
                this.bbj.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bdT, null, null));
            } else if (view == this) {
                this.bbj.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bdT, null, null));
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        at.k(this.bdJ, t.f.addresslist_item_bg);
        this.aRP.invalidate();
    }
}
