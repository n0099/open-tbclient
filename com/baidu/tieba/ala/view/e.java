package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class e {
    private String fyT;
    private boolean fyU;
    private TextView heA;
    private FrameLayout heB;
    private HeadImageView heC;
    private TextView heD;
    private Context mContext;
    private String mPortrait;
    private View view;

    public e(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.fyT = str;
        this.fyU = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.heA = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.heB = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.heC = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.heD = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.heC != null) {
            this.heC.setIsRound(true);
            this.heC.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
