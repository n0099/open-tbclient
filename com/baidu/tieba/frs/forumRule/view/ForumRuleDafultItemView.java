package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ForumRuleDafultItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f15968e;

    public ForumRuleDafultItemView(Context context) {
        this(context, null);
    }

    public final void a(String str, String str2) {
        EMTextView eMTextView = new EMTextView(this.f15968e);
        eMTextView.setText(str);
        addView(eMTextView);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eMTextView.getLayoutParams();
        marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X008);
        eMTextView.setLayoutParams(marginLayoutParams);
        EMTextView eMTextView2 = new EMTextView(this.f15968e);
        eMTextView2.setText(str2);
        addView(eMTextView2);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) eMTextView2.getLayoutParams();
        marginLayoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        eMTextView2.setLayoutParams(marginLayoutParams2);
    }

    public final void b() {
        a(this.f15968e.getResources().getString(R.string.forum_rule_defalt_one_title), this.f15968e.getResources().getString(R.string.forum_rule_defalt_one_content));
        a(this.f15968e.getResources().getString(R.string.forum_rule_defalt_two_title), this.f15968e.getResources().getString(R.string.forum_rule_defalt_two_content));
        a(this.f15968e.getResources().getString(R.string.forum_rule_defalt_three_title), this.f15968e.getResources().getString(R.string.forum_rule_defalt_three_content));
        a(this.f15968e.getResources().getString(R.string.forum_rule_defalt_four_title), this.f15968e.getResources().getString(R.string.forum_rule_defalt_four_content));
    }

    public ForumRuleDafultItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForumRuleDafultItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15968e = context;
        setOrientation(1);
        b();
    }
}
