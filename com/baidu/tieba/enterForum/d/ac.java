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
    private ViewEventCenter aLU;
    private View aNI;
    private BarImageView aNJ;
    private TextView aNK;
    private TextView aNL;
    private TextView aNM;
    private TextView aNN;
    private TextView aNO;
    private com.baidu.tieba.enterForum.b.f aNP;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.aNI = findViewById(i.f.view_root);
        this.aNK = (TextView) findViewById(i.f.forum_name);
        this.aNL = (TextView) findViewById(i.f.forum_follows_count);
        this.aNM = (TextView) findViewById(i.f.forum_thread_count);
        this.aNN = (TextView) findViewById(i.f.forum_intro);
        this.aNJ = (BarImageView) findViewById(i.f.forum_avatar);
        this.aNO = (TextView) findViewById(i.f.tv_add_love);
        this.aNO.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aNO.setVisibility(0);
        } else {
            this.aNO.setVisibility(8);
        }
    }

    private String fl(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.f fVar) {
        if (fVar != null) {
            this.aNP = fVar;
            if (fVar.getType() == 0) {
                setVisibility(0);
                this.aNK.setText(fVar.getForumName());
                this.aNL.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.attention_n)) + fl(fVar.Ip()));
                this.aNM.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.text_post)) + fl(fVar.Iq()));
                this.aNN.setText(fVar.getSlogan());
                if (!StringUtils.isNULL(fVar.getAvatar())) {
                    this.aNJ.d(fVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aLU = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aLU != null) {
            if (view == this.aNO) {
                this.aLU.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aNP, null, null));
            } else if (view == this) {
                this.aLU.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aNP, null, null));
            }
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        an.i(this.aNI, i.e.addresslist_item_bg);
        this.aNJ.invalidate();
    }
}
