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
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private ViewEventCenter bxK;
    private View bzp;
    private ah bzq;
    private TextView bzr;
    private TextView bzs;
    private BannerView bzt;
    private TextView bzu;
    private TextView bzv;
    private View bzw;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bxK = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(r.j.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bzu = (TextView) findViewById(r.h.search_root);
        this.bzu.setOnClickListener(new s(this));
        this.bzv = (TextView) findViewById(r.h.attention_forum_title);
        this.bzr = (TextView) findViewById(r.h.space_line);
        this.bzs = (TextView) findViewById(r.h.space_line_bottom);
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bzp == null) {
                Vv();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.bzp);
            this.bzp.setVisibility(0);
        } else if (this.bzp != null) {
            this.bzp.setVisibility(8);
        }
    }

    public void Vu() {
        ((ViewStub) findViewById(r.h.viewstub_frequently_foruminfo_view)).inflate();
        this.bzq = new ah(getContext(), (LinearLayout) findViewById(r.h.frequently_forum_info_layout));
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.Uc() != null) {
            if (this.bzq == null) {
                Vu();
            }
            this.bzq.tg();
            if (bVar.Uc() != null && bVar.Uc().Uh() != null && bVar.Uc().Uh().size() > 0) {
                this.bzq.setVisibility(0);
                this.bzr.setVisibility(0);
                this.bzq.d(bVar.Uc().Uh(), tbPageContext);
                return;
            }
            this.bzr.setVisibility(8);
            this.bzq.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.bzr.setVisibility(8);
            this.bzq.setVisibility(8);
            return;
        }
        this.bzq.setVisibility(0);
        this.bzr.setVisibility(0);
        this.bzq.d(list, tbPageContext);
    }

    public void Vv() {
        this.bzp = ((ViewStub) findViewById(r.h.viewstub_guide)).inflate();
        View findViewById = this.bzp.findViewById(r.h.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.bzt != null) {
            this.bzt.lJ();
        }
        if (this.bzw != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bzw);
        }
        if (this.bzq != null) {
            this.bzq.tg();
        }
    }

    public void setSearchHint(String str) {
        this.bzu.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bzw;
    }

    public void ag(View view) {
        if (view != null) {
            if (this.bzw != null) {
                removeView(this.bzw);
            }
            this.bzw = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.bzv.setVisibility(0);
            this.bzs.setVisibility(0);
            return;
        }
        this.bzv.setVisibility(8);
        this.bzs.setVisibility(8);
    }
}
