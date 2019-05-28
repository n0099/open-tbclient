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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ForumHeaderView extends LinearLayout implements View.OnClickListener {
    private com.baidu.tieba.enterForum.data.b eQt;
    private LinearLayout eWM;
    private TextView eWN;
    private ImageView eWO;

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
        this.eWM = (LinearLayout) findViewById(R.id.search_container);
        this.eWN = (TextView) findViewById(R.id.search_text);
        this.eWO = (ImageView) findViewById(R.id.search_icon);
        setDescendantFocusability(262144);
        this.eWM.setOnClickListener(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(l.af(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(l.g(getContext(), R.dimen.tbds140), 1073741824));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TbadkCoreApplication.isLogin()) {
            TiebaStatic.eventStat(getContext(), "notlogin_8", "click", 1, new Object[0]);
        }
        TiebaStatic.log(new am("c13367").bT("obj_location", "1"));
        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(getContext())));
    }

    public void setSearchHint(String str) {
        this.eWN.setText(UtilHelper.getFixedText(str, 20));
    }

    public void onChangeSkinType() {
        al.c(this.eWO, (int) R.drawable.icon_ba_search_n);
        al.j(this.eWN, R.color.cp_cont_d);
        if (this.eQt != null && this.eQt.eQV) {
            al.k(this.eWM, R.drawable.enter_forum_search_ad_bg);
        } else {
            al.k(this.eWM, R.drawable.enter_forum_search_bg);
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eQt = bVar;
        if (bVar != null && bVar.eQV) {
            al.k(this.eWM, R.drawable.enter_forum_search_ad_bg);
        } else {
            al.k(this.eWM, R.drawable.enter_forum_search_bg);
        }
    }
}
