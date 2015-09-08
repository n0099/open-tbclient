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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ab extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aMG;
    private com.baidu.tieba.enterForum.b.e aOA;
    private View aOt;
    private BarImageView aOu;
    private TextView aOv;
    private TextView aOw;
    private TextView aOx;
    private TextView aOy;
    private TextView aOz;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.aOt = findViewById(i.f.view_root);
        this.aOv = (TextView) findViewById(i.f.forum_name);
        this.aOw = (TextView) findViewById(i.f.forum_follows_count);
        this.aOx = (TextView) findViewById(i.f.forum_thread_count);
        this.aOy = (TextView) findViewById(i.f.forum_intro);
        this.aOu = (BarImageView) findViewById(i.f.forum_avatar);
        this.aOz = (TextView) findViewById(i.f.tv_add_love);
        this.aOz.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aOz.setVisibility(0);
        } else {
            this.aOz.setVisibility(8);
        }
    }

    private String eY(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.e eVar) {
        if (eVar != null) {
            this.aOA = eVar;
            if (eVar.getType() == 0) {
                setVisibility(0);
                this.aOv.setText(eVar.getForumName());
                this.aOw.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.attention_n)) + eY(eVar.Ii()));
                this.aOx.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.h.text_post)) + eY(eVar.Ij()));
                this.aOy.setText(eVar.getSlogan());
                if (!StringUtils.isNULL(eVar.getAvatar())) {
                    this.aOu.d(eVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aMG = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aMG != null) {
            if (view == this.aOz) {
                this.aMG.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aOA, null, null));
            } else if (view == this) {
                this.aMG.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aOA, null, null));
            }
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        al.h(this.aOt, i.e.addresslist_item_bg);
        this.aOu.invalidate();
    }
}
