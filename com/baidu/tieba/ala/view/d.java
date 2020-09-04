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
    private String fvI;
    private boolean fvJ;
    private TextView hag;
    private FrameLayout hah;
    private HeadImageView hai;
    private TextView haj;
    private Context mContext;
    private String mPortrait;
    private View view;

    public d(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.fvI = str;
        this.fvJ = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.hag = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.hah = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.hai = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.haj = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.hai != null) {
            this.hai.setIsRound(true);
            this.hai.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
