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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private TextView blH;
    private ViewEventCenter bxK;
    private BarImageView bzI;
    private TextView bzJ;
    private TextView bzK;
    private TextView bzL;
    private TextView bzM;
    private com.baidu.tieba.enterForum.b.g bzN;
    private View bzz;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(r.j.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.bzz = findViewById(r.h.view_root);
        this.blH = (TextView) findViewById(r.h.forum_name);
        this.bzJ = (TextView) findViewById(r.h.forum_follows_count);
        this.bzK = (TextView) findViewById(r.h.forum_thread_count);
        this.bzL = (TextView) findViewById(r.h.forum_intro);
        this.bzI = (BarImageView) findViewById(r.h.forum_avatar);
        this.bzM = (TextView) findViewById(r.h.tv_add_love);
        this.bzM.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.bzM.setVisibility(0);
        } else {
            this.bzM.setVisibility(8);
        }
    }

    private String hx(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.g gVar) {
        if (gVar != null) {
            this.bzN = gVar;
            if (gVar.getType() == 0) {
                setVisibility(0);
                this.blH.setText(gVar.getForumName());
                this.bzJ.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(r.l.attention)) + hx(gVar.Um()));
                this.bzK.setText(String.valueOf(TbadkCoreApplication.m9getInst().getString(r.l.text_post)) + hx(gVar.Un()));
                this.bzL.setText(gVar.getSlogan());
                if (!StringUtils.isNULL(gVar.getAvatar())) {
                    this.bzI.c(gVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bxK = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bxK != null) {
            if (view == this.bzM) {
                this.bxK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.bzN, null, null));
            } else if (view == this) {
                this.bxK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.bzN, null, null));
            }
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        ap.j(this.bzz, r.g.addresslist_item_bg);
        this.bzI.invalidate();
    }
}
