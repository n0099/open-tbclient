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
    private String fZj;
    private boolean fZk;
    private TextView hLr;
    private FrameLayout hLs;
    private HeadImageView hLt;
    private TextView hLu;
    private Context mContext;
    private String mPortrait;
    private View view;

    public e(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.fZj = str;
        this.fZk = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.hLr = (TextView) this.view.findViewById(a.f.ala_rank_list_user_rank);
        this.hLs = (FrameLayout) this.view.findViewById(a.f.ala_rank_list_header_layout);
        this.hLt = (HeadImageView) this.view.findViewById(a.f.ala_rank_list_user_header);
        this.hLu = (TextView) this.view.findViewById(a.f.ala_rank_list_user_name);
        if (this.hLt != null) {
            this.hLt.setIsRound(true);
            this.hLt.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
