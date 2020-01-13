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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ForumHeaderView extends LinearLayout implements View.OnClickListener {
    private com.baidu.tieba.enterForum.data.b fQS;
    private LinearLayout fXF;
    private TextView fXG;
    private ImageView fXH;

    public ForumHeaderView(Context context) {
        super(context);
        init();
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_enterforum_search, (ViewGroup) this, true);
        this.fXF = (LinearLayout) findViewById(R.id.search_container);
        this.fXG = (TextView) findViewById(R.id.search_text);
        this.fXH = (ImageView) findViewById(R.id.search_icon);
        setDescendantFocusability(262144);
        this.fXF.setOnClickListener(this);
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
        TiebaStatic.log(new an("c13367").cp("obj_location", "1"));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(getContext())));
    }

    public void setSearchHint(String str) {
        this.fXG.setText(UtilHelper.getFixedText(str, 20));
    }

    public void onChangeSkinType() {
        if (this.fQS != null && this.fQS.fRw) {
            if (this.fQS.fRy > 0) {
                SvgManager.aEp().a(this.fXH, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                am.setViewTextColor(this.fXG, (int) R.color.white_alpha50);
                am.setBackgroundResource(this.fXF, R.drawable.enter_forum_search_ad_bg);
                return;
            }
            SvgManager.aEp().a(this.fXH, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.fXG, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fXF, R.drawable.enter_forum_search_bg);
            return;
        }
        SvgManager.aEp().a(this.fXH, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.fXG, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fXF, R.drawable.enter_forum_search_bg);
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fQS = bVar;
        onChangeSkinType();
    }
}
