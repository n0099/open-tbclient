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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aRj;
    private TextView bbT;
    private View brO;
    private BarImageView brX;
    private TextView brY;
    private TextView brZ;
    private TextView bsa;
    private TextView bsb;
    private com.baidu.tieba.enterForum.b.g bsc;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(r.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.brO = findViewById(r.g.view_root);
        this.bbT = (TextView) findViewById(r.g.forum_name);
        this.brY = (TextView) findViewById(r.g.forum_follows_count);
        this.brZ = (TextView) findViewById(r.g.forum_thread_count);
        this.bsa = (TextView) findViewById(r.g.forum_intro);
        this.brX = (BarImageView) findViewById(r.g.forum_avatar);
        this.bsb = (TextView) findViewById(r.g.tv_add_love);
        this.bsb.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bsb.setVisibility(0);
        } else {
            this.bsb.setVisibility(8);
        }
    }

    private String gL(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bsc = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.bbT.setText(gVar.getForumName());
                this.brY.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(r.j.attention)) + gL(gVar.SR()));
                this.brZ.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(r.j.text_post)) + gL(gVar.SS()));
                this.bsa.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.brX.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aRj = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aRj != null) {
            if (view == this.bsb) {
                this.aRj.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bsc, null, null));
            } else if (view == this) {
                this.aRj.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bsc, null, null));
            }
        }
    }

    public void s(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        ar.k(this.brO, r.f.addresslist_item_bg);
        this.brX.invalidate();
    }
}
