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
    private String fYQ;
    private boolean fYR;
    private TextView hKY;
    private FrameLayout hKZ;
    private HeadImageView hLa;
    private TextView hLb;
    private Context mContext;
    private String mPortrait;
    private View view;

    public e(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.fYQ = str;
        this.fYR = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.hKY = (TextView) this.view.findViewById(a.f.ala_rank_list_user_rank);
        this.hKZ = (FrameLayout) this.view.findViewById(a.f.ala_rank_list_header_layout);
        this.hLa = (HeadImageView) this.view.findViewById(a.f.ala_rank_list_user_header);
        this.hLb = (TextView) this.view.findViewById(a.f.ala_rank_list_user_name);
        if (this.hLa != null) {
            this.hLa.setIsRound(true);
            this.hLa.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
