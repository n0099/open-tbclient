package com.baidu.tieba.enterForum.hotuserrank.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import d.b.c.e.p.l;
import d.b.h0.r.f0.m.b;
/* loaded from: classes4.dex */
public class HotUserRankLikeButton extends DynamicUserLikeButton {
    public HotUserRankLikeButton(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.view.DynamicUserLikeButton, d.b.h0.r.f0.q.b
    public void a(boolean z, int i) {
        if (z) {
            b bVar = new b();
            bVar.r(R.color.CAM_X0109);
            setConfig(bVar);
            setClickable(true);
            if (i == 1) {
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else if (i == 2) {
                setText(TbadkCoreApplication.getInst().getString(R.string.each_concerned));
            }
        } else {
            b bVar2 = new b();
            bVar2.q(R.color.CAM_X0302);
            setConfig(bVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        if (i == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = l.g(getContext(), R.dimen.tbds196);
                setLayoutParams(layoutParams);
            }
        } else {
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = l.g(getContext(), R.dimen.tbds156);
                setLayoutParams(layoutParams2);
            }
        }
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public HotUserRankLikeButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HotUserRankLikeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
