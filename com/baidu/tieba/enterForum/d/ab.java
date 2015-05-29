package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aET;
    private View aGF;
    private BarImageView aGG;
    private TextView aGH;
    private TextView aGI;
    private TextView aGJ;
    private TextView aGK;
    private TextView aGL;
    private com.baidu.tieba.enterForum.b.e aGM;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.baidu.adp.lib.g.b.hr().a(getContext(), com.baidu.tieba.r.enter_forum_recommendinfo_item, this, true);
        init();
    }

    private void init() {
        this.aGF = findViewById(com.baidu.tieba.q.view_root);
        this.aGH = (TextView) findViewById(com.baidu.tieba.q.forum_name);
        this.aGI = (TextView) findViewById(com.baidu.tieba.q.forum_follows_count);
        this.aGJ = (TextView) findViewById(com.baidu.tieba.q.forum_thread_count);
        this.aGK = (TextView) findViewById(com.baidu.tieba.q.forum_intro);
        this.aGG = (BarImageView) findViewById(com.baidu.tieba.q.forum_avatar);
        this.aGL = (TextView) findViewById(com.baidu.tieba.q.tv_add_love);
        this.aGL.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aGL.setVisibility(0);
        } else {
            this.aGL.setVisibility(8);
        }
    }

    private String eL(int i) {
        return i <= 9999999 ? String.valueOf(i) : String.format("%.1fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.e eVar) {
        if (eVar != null) {
            this.aGM = eVar;
            if (eVar.getType() == 0) {
                setVisibility(0);
                this.aGH.setText(eVar.getForumName());
                this.aGI.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.attention_n)) + eL(eVar.HI()));
                this.aGJ.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.text_post)) + eL(eVar.HJ()));
                this.aGK.setText(eVar.getSlogan());
                if (!StringUtils.isNULL(eVar.getAvatar())) {
                    this.aGG.c(eVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aET = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aET != null) {
            if (view == this.aGL) {
                this.aET.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aGM, null, null));
            } else if (view == this) {
                this.aET.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aGM, null, null));
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        ay.i(this.aGF, com.baidu.tieba.p.addresslist_item_bg);
        this.aGG.invalidate();
    }
}
