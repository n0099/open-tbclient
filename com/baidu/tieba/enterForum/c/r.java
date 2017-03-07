package com.baidu.tieba.enterForum.c;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private ViewEventCenter bEQ;
    private TextView bGA;
    private TextView bGB;
    private View bGC;
    private View bGv;
    private ah bGw;
    private TextView bGx;
    private TextView bGy;
    private BannerView bGz;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bEQ = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bGA = (TextView) findViewById(w.h.search_root);
        this.bGA.setOnClickListener(new s(this));
        this.bGB = (TextView) findViewById(w.h.attention_forum_title);
        this.bGx = (TextView) findViewById(w.h.space_line);
        this.bGy = (TextView) findViewById(w.h.space_line_bottom);
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bGv == null) {
                Wt();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.bGv);
            this.bGv.setVisibility(0);
        } else if (this.bGv != null) {
            this.bGv.setVisibility(8);
        }
    }

    public void Ws() {
        ((ViewStub) findViewById(w.h.viewstub_frequently_foruminfo_view)).inflate();
        this.bGw = new ah(getContext(), (LinearLayout) findViewById(w.h.frequently_forum_info_layout));
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.Va() != null) {
            if (this.bGw == null) {
                Ws();
            }
            this.bGw.tD();
            if (bVar.Va() != null && bVar.Va().Vf() != null && bVar.Va().Vf().size() > 0) {
                this.bGw.setVisibility(0);
                this.bGx.setVisibility(0);
                this.bGw.d(bVar.Va().Vf(), tbPageContext);
                return;
            }
            this.bGx.setVisibility(8);
            this.bGw.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.bGx.setVisibility(8);
            this.bGw.setVisibility(8);
            return;
        }
        this.bGw.setVisibility(0);
        this.bGx.setVisibility(0);
        this.bGw.d(list, tbPageContext);
    }

    public void Wt() {
        this.bGv = ((ViewStub) findViewById(w.h.viewstub_guide)).inflate();
        View findViewById = this.bGv.findViewById(w.h.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.bGz != null) {
            this.bGz.AO();
        }
        if (this.bGC != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bGC);
        }
        if (this.bGw != null) {
            this.bGw.tD();
        }
    }

    public void setSearchHint(String str) {
        this.bGA.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bGC;
    }

    public void ae(View view) {
        if (view != null) {
            if (this.bGC != null) {
                removeView(this.bGC);
            }
            this.bGC = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.bGB.setVisibility(0);
            this.bGy.setVisibility(0);
            return;
        }
        this.bGB.setVisibility(8);
        this.bGy.setVisibility(8);
    }
}
