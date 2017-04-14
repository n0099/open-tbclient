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
    private ViewEventCenter bEJ;
    private View bGo;
    private ah bGp;
    private TextView bGq;
    private TextView bGr;
    private BannerView bGs;
    private TextView bGt;
    private TextView bGu;
    private View bGv;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bEJ = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bGt = (TextView) findViewById(w.h.search_root);
        this.bGt.setOnClickListener(new s(this));
        this.bGu = (TextView) findViewById(w.h.attention_forum_title);
        this.bGq = (TextView) findViewById(w.h.space_line);
        this.bGr = (TextView) findViewById(w.h.space_line_bottom);
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bGo == null) {
                WR();
            }
            com.baidu.tbadk.m.a.a(tbPageContext, this.bGo);
            this.bGo.setVisibility(0);
        } else if (this.bGo != null) {
            this.bGo.setVisibility(8);
        }
    }

    public void WQ() {
        ((ViewStub) findViewById(w.h.viewstub_frequently_foruminfo_view)).inflate();
        this.bGp = new ah(getContext(), (LinearLayout) findViewById(w.h.frequently_forum_info_layout));
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.Vy() != null) {
            if (this.bGp == null) {
                WQ();
            }
            this.bGp.onChangeSkinType();
            if (bVar.Vy() != null && bVar.Vy().VD() != null && bVar.Vy().VD().size() > 0) {
                this.bGp.setVisibility(0);
                this.bGq.setVisibility(0);
                this.bGp.d(bVar.Vy().VD(), tbPageContext);
                return;
            }
            this.bGq.setVisibility(8);
            this.bGp.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.bGq.setVisibility(8);
            this.bGp.setVisibility(8);
            return;
        }
        this.bGp.setVisibility(0);
        this.bGq.setVisibility(0);
        this.bGp.d(list, tbPageContext);
    }

    public void WR() {
        this.bGo = ((ViewStub) findViewById(w.h.viewstub_guide)).inflate();
        View findViewById = this.bGo.findViewById(w.h.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        if (this.bGs != null) {
            this.bGs.Bn();
        }
        if (this.bGv != null) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bGv);
        }
        if (this.bGp != null) {
            this.bGp.onChangeSkinType();
        }
    }

    public void setSearchHint(String str) {
        this.bGt.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bGv;
    }

    public void ae(View view) {
        if (view != null) {
            if (this.bGv != null) {
                removeView(this.bGv);
            }
            this.bGv = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.bGu.setVisibility(0);
            this.bGr.setVisibility(0);
            return;
        }
        this.bGu.setVisibility(8);
        this.bGr.setVisibility(8);
    }
}
