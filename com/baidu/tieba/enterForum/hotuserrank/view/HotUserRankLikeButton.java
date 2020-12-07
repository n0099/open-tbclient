package com.baidu.tieba.enterForum.hotuserrank.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
/* loaded from: classes22.dex */
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
    public void s(boolean z, int i) {
        if (z) {
            b bVar = new b();
            bVar.rj(R.color.CAM_X0109);
            setConfig(bVar);
            setClickable(true);
            if (i == 1) {
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else if (i == 2) {
                setText(TbadkCoreApplication.getInst().getString(R.string.each_concerned));
            }
        } else {
            b bVar2 = new b();
            bVar2.rh(R.color.CAM_X0302);
            setConfig(bVar2);
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
