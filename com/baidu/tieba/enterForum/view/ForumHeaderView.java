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
    private com.baidu.tieba.enterForum.data.b eXg;
    private LinearLayout fdZ;
    private TextView fea;
    private ImageView feb;

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
        this.fdZ = (LinearLayout) findViewById(R.id.search_container);
        this.fea = (TextView) findViewById(R.id.search_text);
        this.feb = (ImageView) findViewById(R.id.search_icon);
        setDescendantFocusability(262144);
        this.fdZ.setOnClickListener(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(l.af(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(l.g(getContext(), R.dimen.tbds114), 1073741824));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TbadkCoreApplication.isLogin()) {
            TiebaStatic.eventStat(getContext(), "notlogin_8", "click", 1, new Object[0]);
        }
        TiebaStatic.log(new an("c13367").bT("obj_location", "1"));
        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(getContext())));
    }

    public void setSearchHint(String str) {
        this.fea.setText(UtilHelper.getFixedText(str, 20));
    }

    public void onChangeSkinType() {
        if (this.eXg != null && this.eXg.eXL) {
            if (this.eXg.eXN > 0) {
                SvgManager.ajv().a(this.feb, R.drawable.icon_pure_search_import_n_svg, R.color.white_alpha50, null);
                am.j(this.fea, R.color.white_alpha50);
                am.k(this.fdZ, R.drawable.enter_forum_search_ad_bg);
                return;
            }
            SvgManager.ajv().a(this.feb, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
            am.j(this.fea, R.color.cp_cont_d);
            am.k(this.fdZ, R.drawable.enter_forum_search_bg);
            return;
        }
        SvgManager.ajv().a(this.feb, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
        am.j(this.fea, R.color.cp_cont_d);
        am.k(this.fdZ, R.drawable.enter_forum_search_bg);
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eXg = bVar;
        onChangeSkinType();
    }
}
