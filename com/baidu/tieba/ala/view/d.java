package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes7.dex */
public class d {
    private String fvE;
    private boolean fvF;
    private TextView hac;
    private FrameLayout had;
    private HeadImageView hae;
    private TextView haf;
    private Context mContext;
    private String mPortrait;
    private View view;

    public d(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.fvE = str;
        this.fvF = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.hac = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.had = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.hae = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.haf = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.hae != null) {
            this.hae.setIsRound(true);
            this.hae.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
