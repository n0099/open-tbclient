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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ac extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aLM;
    private View aNA;
    private BarImageView aNB;
    private TextView aNC;
    private TextView aND;
    private TextView aNE;
    private TextView aNF;
    private TextView aNG;
    private com.baidu.tieba.enterForum.b.f aNH;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.aNA = findViewById(i.f.view_root);
        this.aNC = (TextView) findViewById(i.f.forum_name);
        this.aND = (TextView) findViewById(i.f.forum_follows_count);
        this.aNE = (TextView) findViewById(i.f.forum_thread_count);
        this.aNF = (TextView) findViewById(i.f.forum_intro);
        this.aNB = (BarImageView) findViewById(i.f.forum_avatar);
        this.aNG = (TextView) findViewById(i.f.tv_add_love);
        this.aNG.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aNG.setVisibility(0);
        } else {
            this.aNG.setVisibility(8);
        }
    }

    private String fd(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.f fVar) {
        if (fVar != null) {
            this.aNH = fVar;
            if (fVar.getType() == 0) {
                setVisibility(0);
                this.aNC.setText(fVar.getForumName());
                this.aND.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.attention_n)) + fd(fVar.Id()));
                this.aNE.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.text_post)) + fd(fVar.Ie()));
                this.aNF.setText(fVar.getSlogan());
                if (!StringUtils.isNULL(fVar.getAvatar())) {
                    this.aNB.d(fVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aLM = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLM != null) {
            if (view == this.aNG) {
                this.aLM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aNH, null, null));
            } else if (view == this) {
                this.aLM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aNH, null, null));
            }
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        an.i(this.aNA, i.e.addresslist_item_bg);
        this.aNB.invalidate();
    }
}
