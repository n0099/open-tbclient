package com.baidu.tieba.enterForum.hotuserrank.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
/* loaded from: classes16.dex */
public class HotUserRankLikeButton extends DynamicUserLikeButton {
    public HotUserRankLikeButton(Context context) {
        super(context);
    }

    public HotUserRankLikeButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HotUserRankLikeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.view.DynamicUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        if (z) {
            c cVar = new c();
            cVar.mX(R.color.cp_cont_d);
            setConfig(cVar);
            setClickable(true);
            if (i == 1) {
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else if (i == 2) {
                setText(TbadkCoreApplication.getInst().getString(R.string.each_concerned));
            }
        } else {
            c cVar2 = new c();
            cVar2.mV(R.color.cp_link_tip_a);
            setConfig(cVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        if (i == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = l.getDimens(getContext(), R.dimen.tbds196);
                setLayoutParams(layoutParams);
            }
        } else {
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = l.getDimens(getContext(), R.dimen.tbds156);
                setLayoutParams(layoutParams2);
            }
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
