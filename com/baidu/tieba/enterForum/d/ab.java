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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private BarImageView aOZ;
    private TextView aPa;
    private TextView aPb;
    private TextView aPc;
    private TextView aPd;
    private ViewEventCenter aWA;
    private View aYZ;
    private TextView aZi;
    private com.baidu.tieba.enterForum.b.f aZj;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.aYZ = findViewById(t.g.view_root);
        this.aPa = (TextView) findViewById(t.g.forum_name);
        this.aPb = (TextView) findViewById(t.g.forum_follows_count);
        this.aPc = (TextView) findViewById(t.g.forum_thread_count);
        this.aPd = (TextView) findViewById(t.g.forum_intro);
        this.aOZ = (BarImageView) findViewById(t.g.forum_avatar);
        this.aZi = (TextView) findViewById(t.g.tv_add_love);
        this.aZi.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aZi.setVisibility(0);
        } else {
            this.aZi.setVisibility(8);
        }
    }

    private String fZ(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.f fVar) {
        if (fVar != null) {
            this.aZj = fVar;
            if (fVar.getType() == 0) {
                setVisibility(0);
                this.aPa.setText(fVar.getForumName());
                this.aPb.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(t.j.attention_n)) + fZ(fVar.LP()));
                this.aPc.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(t.j.text_post)) + fZ(fVar.LQ()));
                this.aPd.setText(fVar.getSlogan());
                if (!StringUtils.isNULL(fVar.getAvatar())) {
                    this.aOZ.d(fVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aWA = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWA != null) {
            if (view == this.aZi) {
                this.aWA.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aZj, null, null));
            } else if (view == this) {
                this.aWA.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aZj, null, null));
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        ar.k(this.aYZ, t.f.addresslist_item_bg);
        this.aOZ.invalidate();
    }
}
