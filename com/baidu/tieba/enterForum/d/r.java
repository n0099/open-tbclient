package com.baidu.tieba.enterForum.d;

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
    private ViewEventCenter aRj;
    private View brE;
    private ah brF;
    private TextView brG;
    private TextView brH;
    private BannerView brI;
    private TextView brJ;
    private TextView brK;
    private View brL;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aRj = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(r.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.brJ = (TextView) findViewById(r.g.search_root);
        this.brJ.setOnClickListener(new s(this));
        this.brK = (TextView) findViewById(r.g.attention_forum_title);
        this.brG = (TextView) findViewById(r.g.space_line);
        this.brH = (TextView) findViewById(r.g.space_line_bottom);
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.brE == null) {
                Ua();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.brE);
            this.brE.setVisibility(0);
        } else if (this.brE != null) {
            this.brE.setVisibility(8);
        }
    }

    public void TZ() {
        ((ViewStub) findViewById(r.g.viewstub_frequently_foruminfo_view)).inflate();
        this.brF = new ah(getContext(), (LinearLayout) findViewById(r.g.frequently_forum_info_layout));
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.SH() != null) {
            if (this.brF == null) {
                TZ();
            }
            this.brF.tm();
            if (bVar.SH() != null && bVar.SH().SM() != null && bVar.SH().SM().size() > 0) {
                this.brF.setVisibility(0);
                this.brG.setVisibility(0);
                this.brF.d(bVar.SH().SM(), tbPageContext);
                return;
            }
            this.brG.setVisibility(8);
            this.brF.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.brG.setVisibility(8);
            this.brF.setVisibility(8);
            return;
        }
        this.brF.setVisibility(0);
        this.brG.setVisibility(0);
        this.brF.d(list, tbPageContext);
    }

    public void Ua() {
        this.brE = ((ViewStub) findViewById(r.g.viewstub_guide)).inflate();
        View findViewById = this.brE.findViewById(r.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void s(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.brI != null) {
            this.brI.lR();
        }
        if (this.brL != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.brL);
        }
        if (this.brF != null) {
            this.brF.tm();
        }
    }

    public void setSearchHint(String str) {
        this.brJ.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.brL;
    }

    public void ab(View view) {
        if (view != null) {
            if (this.brL != null) {
                removeView(this.brL);
            }
            this.brL = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.brK.setVisibility(0);
            this.brH.setVisibility(0);
            return;
        }
        this.brK.setVisibility(8);
        this.brH.setVisibility(8);
    }
}
