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
    private String fLc;
    private boolean fLd;
    private TextView htD;
    private FrameLayout htE;
    private HeadImageView htF;
    private TextView htG;
    private Context mContext;
    private String mPortrait;
    private View view;

    public e(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.fLc = str;
        this.fLd = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.htD = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.htE = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.htF = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.htG = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.htF != null) {
            this.htF.setIsRound(true);
            this.htF.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
