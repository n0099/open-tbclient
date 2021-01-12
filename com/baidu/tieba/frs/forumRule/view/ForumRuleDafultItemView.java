package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ForumRuleDafultItemView extends LinearLayout {
    private Context mContext;

    public ForumRuleDafultItemView(Context context) {
        this(context, null);
    }

    public ForumRuleDafultItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForumRuleDafultItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setOrientation(1);
        init();
    }

    private void init() {
        eY(this.mContext.getResources().getString(R.string.forum_rule_defalt_one_title), this.mContext.getResources().getString(R.string.forum_rule_defalt_one_content));
        eY(this.mContext.getResources().getString(R.string.forum_rule_defalt_two_title), this.mContext.getResources().getString(R.string.forum_rule_defalt_two_content));
        eY(this.mContext.getResources().getString(R.string.forum_rule_defalt_three_title), this.mContext.getResources().getString(R.string.forum_rule_defalt_three_content));
        eY(this.mContext.getResources().getString(R.string.forum_rule_defalt_four_title), this.mContext.getResources().getString(R.string.forum_rule_defalt_four_content));
    }

    private void eY(String str, String str2) {
        EMTextView eMTextView = new EMTextView(this.mContext);
        eMTextView.setText(str);
        addView(eMTextView);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eMTextView.getLayoutParams();
        marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X008);
        eMTextView.setLayoutParams(marginLayoutParams);
        EMTextView eMTextView2 = new EMTextView(this.mContext);
        eMTextView2.setText(str2);
        addView(eMTextView2);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) eMTextView2.getLayoutParams();
        marginLayoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        eMTextView2.setLayoutParams(marginLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeSkin(int i) {
        if (getChildCount() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < getChildCount()) {
                    EMTextView eMTextView = (EMTextView) getChildAt(i3);
                    if (i3 % 2 != 0) {
                        com.baidu.tbadk.core.elementsMaven.c.bv(eMTextView).nV(R.color.CAM_X0107).nY(R.dimen.M_T_X003);
                    } else {
                        com.baidu.tbadk.core.elementsMaven.c.bv(eMTextView).nV(R.color.CAM_X0107).nX(R.string.F_X02);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
