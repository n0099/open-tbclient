package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class b {
    private String edJ;
    private boolean edK;
    private TextView fxM;
    private FrameLayout fxN;
    private HeadImageView fxO;
    private TextView fxP;
    private Context mContext;
    private String mPortrait;
    private View view;

    public b(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.edJ = str;
        this.edK = z;
        this.mPortrait = str2;
        initView();
    }

    public void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.fxM = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.fxN = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.fxO = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.fxP = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.fxO != null) {
            this.fxO.setIsRound(true);
            this.fxO.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
