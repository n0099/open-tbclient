package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ForumHeaderView extends LinearLayout implements View.OnClickListener {
    private int from;
    private com.baidu.tieba.enterForum.data.c haQ;
    private LinearLayout hkC;
    private TextView hkD;
    private ImageView hkE;

    public ForumHeaderView(Context context) {
        super(context);
        this.from = 0;
        init();
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.from = 0;
        init();
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.from = 0;
        init();
    }

    public void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_enterforum_search, (ViewGroup) this, true);
        this.hkC = (LinearLayout) findViewById(R.id.search_container);
        this.hkD = (TextView) findViewById(R.id.search_text);
        this.hkE = (ImageView) findViewById(R.id.search_icon);
        setDescendantFocusability(262144);
        this.hkC.setOnClickListener(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(l.getEquipmentWidth(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(l.getDimens(getContext(), R.dimen.tbds114), 1073741824));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TbadkCoreApplication.isLogin()) {
            TiebaStatic.eventStat(getContext(), "notlogin_8", "click", 1, new Object[0]);
        }
        if (this.from != 1) {
            TiebaStatic.log(new ao("c13367").dk("obj_location", "1"));
        } else {
            TiebaStatic.log(new ao("c13648").s("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(getContext())));
    }

    public void setSearchHint(String str) {
        this.hkD.setText(str);
    }

    public void onChangeSkinType() {
        if (this.haQ != null && this.haQ.hbs) {
            if (this.haQ.hbu > 0) {
                SvgManager.aWQ().a(this.hkE, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                an.setViewTextColor(this.hkD, (int) R.color.white_alpha50);
                an.setBackgroundResource(this.hkC, R.drawable.enter_forum_search_ad_bg);
                return;
            }
            SvgManager.aWQ().a(this.hkE, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            an.setViewTextColor(this.hkD, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.hkC, R.drawable.enter_forum_search_bg);
            return;
        }
        SvgManager.aWQ().a(this.hkE, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        an.setViewTextColor(this.hkD, (int) R.color.cp_cont_d);
        an.setBackgroundResource(this.hkC, R.drawable.enter_forum_search_bg);
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.haQ = cVar;
        onChangeSkinType();
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
