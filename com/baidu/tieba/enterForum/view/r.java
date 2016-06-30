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
    private ViewEventCenter bfx;
    private View bvc;
    private FrequentlyForumInfoView bvd;
    private TextView bve;
    private TextView bvf;
    private BannerView bvg;
    private TextView bvh;
    private TextView bvi;
    private View bvj;
    private View bvk;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bfx = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(u.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bvh = (TextView) findViewById(u.g.search_root);
        this.bvh.setOnClickListener(new s(this));
        this.bvi = (TextView) findViewById(u.g.attention_forum_title);
        this.bve = (TextView) findViewById(u.g.space_line);
        this.bvf = (TextView) findViewById(u.g.space_line_bottom);
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bvc == null) {
                Tc();
            }
            com.baidu.tbadk.j.a.a(tbPageContext, this.bvc);
            this.bvc.setVisibility(0);
        } else if (this.bvc != null) {
            this.bvc.setVisibility(8);
        }
    }

    public void Tb() {
        ((ViewStub) findViewById(u.g.viewstub_frequently_foruminfo_view)).inflate();
        this.bvd = (FrequentlyForumInfoView) findViewById(u.g.frequently_forum_info_layout);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.RI() != null) {
            if (this.bvd == null) {
                Tb();
            }
            com.baidu.tbadk.j.a.a(tbPageContext, this.bvd);
            if (bVar.RI() != null && bVar.RI().RN() != null && bVar.RI().RN().size() > 0) {
                this.bvd.setVisibility(0);
                this.bve.setVisibility(0);
                this.bvd.d(bVar.RI().RN(), tbPageContext);
                return;
            }
            this.bve.setVisibility(8);
            this.bvd.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.bve.setVisibility(8);
            this.bvd.setVisibility(8);
            return;
        }
        this.bvd.setVisibility(0);
        this.bve.setVisibility(0);
        this.bvd.d(list, tbPageContext);
    }

    public void Tc() {
        this.bvc = ((ViewStub) findViewById(u.g.viewstub_guide)).inflate();
        View findViewById = this.bvc.findViewById(u.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        if (this.bvg != null) {
            this.bvg.kX();
        }
        if (this.bvj != null) {
            com.baidu.tbadk.j.a.a(tbPageContext, this.bvj);
        }
        if (this.bvd != null) {
            this.bvd.n(tbPageContext);
        }
    }

    public void setSearchHint(String str) {
        this.bvh.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bvj;
    }

    public void aa(View view) {
        if (view != null) {
            if (this.bvj != null) {
                removeView(this.bvj);
            }
            this.bvj = view;
            addView(view, 0);
        }
    }

    public View getTogetherHiBannerView() {
        return this.bvk;
    }

    public void ab(View view) {
        if (view != null) {
            if (this.bvk != null) {
                removeView(this.bvk);
            }
            this.bvk = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.bvi.setVisibility(0);
            this.bvf.setVisibility(0);
            return;
        }
        this.bvi.setVisibility(8);
        this.bvf.setVisibility(8);
    }
}
