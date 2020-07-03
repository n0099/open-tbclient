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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UrlManager;
/* loaded from: classes3.dex */
public class AlaChallengeRankListEnter extends LinearLayout {
    private TextView ger;

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

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_rank_list_entry, this);
        this.ger = (TextView) findViewById(a.g.ala_challenge_rank_enter);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeRankListEnter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = com.baidu.live.v.a.Hm().aZp.aAe;
                if (!StringUtils.isNull(str)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaChallengeRankListEnter.this.getContext()), new String[]{str}, true);
                }
            }
        });
    }

    public void setChallengeRankData(int i, String str) {
    }
}
