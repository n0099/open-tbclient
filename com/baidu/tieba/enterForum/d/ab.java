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
    private ViewEventCenter aMt;
    private View aOg;
    private BarImageView aOh;
    private TextView aOi;
    private TextView aOj;
    private TextView aOk;
    private TextView aOl;
    private TextView aOm;
    private com.baidu.tieba.enterForum.b.e aOn;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_recommendinfo_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.aOg = findViewById(i.f.view_root);
        this.aOi = (TextView) findViewById(i.f.forum_name);
        this.aOj = (TextView) findViewById(i.f.forum_follows_count);
        this.aOk = (TextView) findViewById(i.f.forum_thread_count);
        this.aOl = (TextView) findViewById(i.f.forum_intro);
        this.aOh = (BarImageView) findViewById(i.f.forum_avatar);
        this.aOm = (TextView) findViewById(i.f.tv_add_love);
        this.aOm.setOnClickListener(this);
        setOnClickListener(this);
        if (TbadkCoreApplication.isLogin()) {
            this.aOm.setVisibility(0);
        } else {
            this.aOm.setVisibility(8);
        }
    }

    private String eR(int i) {
        return i <= 999999 ? String.valueOf(i) : String.format("%.0fw", Float.valueOf(i / 10000.0f));
    }

    public void setData(com.baidu.tieba.enterForum.b.e eVar) {
        if (eVar != null) {
            this.aOn = eVar;
            if (eVar.getType() == 0) {
                setVisibility(0);
                this.aOi.setText(eVar.getForumName());
                this.aOj.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.C0057i.attention_n)) + eR(eVar.Iu()));
                this.aOk.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(i.C0057i.text_post)) + eR(eVar.Iv()));
                this.aOl.setText(eVar.getSlogan());
                if (!StringUtils.isNULL(eVar.getAvatar())) {
                    this.aOh.d(eVar.getAvatar(), 10, false);
                    return;
                }
                return;
            }
            setVisibility(4);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aMt = viewEventCenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aMt != null) {
            if (view == this.aOm) {
                this.aMt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, this.aOn, null, null));
            } else if (view == this) {
                this.aMt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, this.aOn, null, null));
            }
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        al.i(this.aOg, i.e.addresslist_item_bg);
        this.aOh.invalidate();
    }
}
