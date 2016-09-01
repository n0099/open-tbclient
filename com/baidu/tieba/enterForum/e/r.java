package com.baidu.tieba.enterForum.e;

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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private ViewEventCenter aOw;
    private View bIF;
    private ah bIG;
    private TextView bIH;
    private TextView bII;
    private BannerView bIJ;
    private TextView bIK;
    private TextView bIL;
    private View bIM;
    private View bIN;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aOw = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bIK = (TextView) findViewById(t.g.search_root);
        this.bIK.setOnClickListener(new s(this));
        this.bIL = (TextView) findViewById(t.g.attention_forum_title);
        this.bIH = (TextView) findViewById(t.g.space_line);
        this.bII = (TextView) findViewById(t.g.space_line_bottom);
    }

    public void b(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bIF == null) {
                Yu();
            }
            com.baidu.tbadk.j.a.a(tbPageContext, this.bIF);
            this.bIF.setVisibility(0);
        } else if (this.bIF != null) {
            this.bIF.setVisibility(8);
        }
    }

    public void Yt() {
        ((ViewStub) findViewById(t.g.viewstub_frequently_foruminfo_view)).inflate();
        this.bIG = new ah(getContext(), (LinearLayout) findViewById(t.g.frequently_forum_info_layout));
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.Xb() != null) {
            if (this.bIG == null) {
                Yt();
            }
            this.bIG.ti();
            if (bVar.Xb() != null && bVar.Xb().Xg() != null && bVar.Xb().Xg().size() > 0) {
                this.bIG.setVisibility(0);
                this.bIH.setVisibility(0);
                this.bIG.d(bVar.Xb().Xg(), tbPageContext);
                return;
            }
            this.bIH.setVisibility(8);
            this.bIG.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.bIH.setVisibility(8);
            this.bIG.setVisibility(8);
            return;
        }
        this.bIG.setVisibility(0);
        this.bIH.setVisibility(0);
        this.bIG.d(list, tbPageContext);
    }

    public void Yu() {
        this.bIF = ((ViewStub) findViewById(t.g.viewstub_guide)).inflate();
        View findViewById = this.bIF.findViewById(t.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        if (this.bIJ != null) {
            this.bIJ.lO();
        }
        if (this.bIM != null) {
            com.baidu.tbadk.j.a.a(tbPageContext, this.bIM);
        }
        if (this.bIG != null) {
            this.bIG.ti();
        }
    }

    public void setSearchHint(String str) {
        this.bIK.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bIM;
    }

    public void aa(View view) {
        if (view != null) {
            if (this.bIM != null) {
                removeView(this.bIM);
            }
            this.bIM = view;
            addView(view, 0);
        }
    }

    public View getTogetherHiBannerView() {
        return this.bIN;
    }

    public void ab(View view) {
        if (view != null) {
            if (this.bIN != null) {
                removeView(this.bIN);
            }
            this.bIN = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.bIL.setVisibility(0);
            this.bII.setVisibility(0);
            return;
        }
        this.bIL.setVisibility(8);
        this.bII.setVisibility(8);
    }
}
