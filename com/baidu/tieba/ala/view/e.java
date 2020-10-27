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
    private String fTt;
    private boolean fTu;
    private TextView hFu;
    private FrameLayout hFv;
    private HeadImageView hFw;
    private TextView hFx;
    private Context mContext;
    private String mPortrait;
    private View view;

    public e(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.fTt = str;
        this.fTu = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.hFu = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.hFv = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.hFw = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.hFx = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.hFw != null) {
            this.hFw.setIsRound(true);
            this.hFw.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
