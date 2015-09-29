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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ac extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aLB;
    private View aNp;
    private BarImageView aNq;
    private TextView aNr;
    private TextView aNs;
    private TextView aNt;
    private TextView aNu;
    private TextView aNv;
    private com.baidu.tieba.enterForum.b.f aNw;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.aNp = findViewById(i.f.view_root);
        this.aNr = (TextView) findViewById(i.f.forum_name);
        this.aNs = (TextView) findViewById(i.f.forum_follows_count);
        this.aNt = (TextView) findViewById(i.f.forum_thread_count);
        this.aNu = (TextView) findViewById(i.f.forum_intro);
        this.aNq = (BarImageView) findViewById(i.f.forum_avatar);
        this.aNv = (TextView) findViewById(i.f.tv_add_love);
        this.aNv.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aNv.setVisibility(0);
        } else {
            this.aNv.setVisibility(8);
        }
    }

    private String fd(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.f fVar) {
        if (fVar != null) {
            this.aNw = fVar;
            if (fVar.getType() == 0) {
                setVisibility(0);
                this.aNr.setText(fVar.getForumName());
                this.aNs.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.attention_n)) + fd(fVar.Id()));
                this.aNt.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.text_post)) + fd(fVar.Ie()));
                this.aNu.setText(fVar.getSlogan());
                if (!StringUtils.isNULL(fVar.getAvatar())) {
                    this.aNq.d(fVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aLB = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLB != null) {
            if (view == this.aNv) {
                this.aLB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aNw, null, null));
            } else if (view == this) {
                this.aLB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aNw, null, null));
            }
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        am.i(this.aNp, i.e.addresslist_item_bg);
        this.aNq.invalidate();
    }
}
