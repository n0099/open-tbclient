package com.baidu.tieba.enterForum.view;

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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private ViewEventCenter bgJ;
    private View bxq;
    private FrequentlyForumInfoView bxr;
    private TextView bxs;
    private TextView bxt;
    private BannerView bxu;
    private TextView bxv;
    private TextView bxw;
    private View bxx;
    private View bxy;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bgJ = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(u.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bxv = (TextView) findViewById(u.g.search_root);
        this.bxv.setOnClickListener(new s(this));
        this.bxw = (TextView) findViewById(u.g.attention_forum_title);
        this.bxs = (TextView) findViewById(u.g.space_line);
        this.bxt = (TextView) findViewById(u.g.space_line_bottom);
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bxq == null) {
                TK();
            }
            com.baidu.tbadk.j.a.a(tbPageContext, this.bxq);
            this.bxq.setVisibility(0);
        } else if (this.bxq != null) {
            this.bxq.setVisibility(8);
        }
    }

    public void TJ() {
        ((ViewStub) findViewById(u.g.viewstub_frequently_foruminfo_view)).inflate();
        this.bxr = (FrequentlyForumInfoView) findViewById(u.g.frequently_forum_info_layout);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.Sp() != null) {
            if (this.bxr == null) {
                TJ();
            }
            com.baidu.tbadk.j.a.a(tbPageContext, this.bxr);
            if (bVar.Sp() != null && bVar.Sp().Su() != null && bVar.Sp().Su().size() > 0) {
                this.bxr.setVisibility(0);
                this.bxs.setVisibility(0);
                this.bxr.d(bVar.Sp().Su(), tbPageContext);
                return;
            }
            this.bxs.setVisibility(8);
            this.bxr.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.bxs.setVisibility(8);
            this.bxr.setVisibility(8);
            return;
        }
        this.bxr.setVisibility(0);
        this.bxs.setVisibility(0);
        this.bxr.d(list, tbPageContext);
    }

    public void TK() {
        this.bxq = ((ViewStub) findViewById(u.g.viewstub_guide)).inflate();
        View findViewById = this.bxq.findViewById(u.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m10getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        if (this.bxu != null) {
            this.bxu.kT();
        }
        if (this.bxx != null) {
            com.baidu.tbadk.j.a.a(tbPageContext, this.bxx);
        }
        if (this.bxr != null) {
            this.bxr.n(tbPageContext);
        }
    }

    public void setSearchHint(String str) {
        this.bxv.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bxx;
    }

    public void aa(View view) {
        if (view != null) {
            if (this.bxx != null) {
                removeView(this.bxx);
            }
            this.bxx = view;
            addView(view, 0);
        }
    }

    public View getTogetherHiBannerView() {
        return this.bxy;
    }

    public void ab(View view) {
        if (view != null) {
            if (this.bxy != null) {
                removeView(this.bxy);
            }
            this.bxy = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.bxw.setVisibility(0);
            this.bxt.setVisibility(0);
            return;
        }
        this.bxw.setVisibility(8);
        this.bxt.setVisibility(8);
    }
}
