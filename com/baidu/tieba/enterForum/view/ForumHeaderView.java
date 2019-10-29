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
/* loaded from: classes4.dex */
public class ForumHeaderView extends LinearLayout implements View.OnClickListener {
    private com.baidu.tieba.enterForum.data.b eZS;
    private LinearLayout fgJ;
    private TextView fgK;
    private ImageView fgL;

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
        this.fgJ = (LinearLayout) findViewById(R.id.search_container);
        this.fgK = (TextView) findViewById(R.id.search_text);
        this.fgL = (ImageView) findViewById(R.id.search_icon);
        setDescendantFocusability(262144);
        this.fgJ.setOnClickListener(this);
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
        TiebaStatic.log(new an("c13367").bS("obj_location", "1"));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(getContext())));
    }

    public void setSearchHint(String str) {
        this.fgK.setText(UtilHelper.getFixedText(str, 20));
    }

    public void onChangeSkinType() {
        if (this.eZS != null && this.eZS.fax) {
            if (this.eZS.faz > 0) {
                SvgManager.amN().a(this.fgL, R.drawable.icon_pure_search_import_n_svg, R.color.white_alpha50, null);
                am.setViewTextColor(this.fgK, (int) R.color.white_alpha50);
                am.setBackgroundResource(this.fgJ, R.drawable.enter_forum_search_ad_bg);
                return;
            }
            SvgManager.amN().a(this.fgL, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
            am.setViewTextColor(this.fgK, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fgJ, R.drawable.enter_forum_search_bg);
            return;
        }
        SvgManager.amN().a(this.fgL, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
        am.setViewTextColor(this.fgK, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.fgJ, R.drawable.enter_forum_search_bg);
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eZS = bVar;
        onChangeSkinType();
    }
}
