package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UrlManager;
/* loaded from: classes6.dex */
public class AlaChallengeRankListEnter extends LinearLayout {
    private TextView eei;

    public AlaChallengeRankListEnter(Context context) {
        super(context);
        initView();
    }

    public AlaChallengeRankListEnter(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AlaChallengeRankListEnter(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_rank_list_entry, this);
        this.eei = (TextView) findViewById(a.g.ala_challenge_rank_enter);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeRankListEnter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = com.baidu.live.l.a.uA().ajX.RV;
                if (!StringUtils.isNull(str)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaChallengeRankListEnter.this.getContext()), new String[]{str}, true);
                }
            }
        });
    }

    public void setChallengeRankData(int i, String str) {
    }
}
