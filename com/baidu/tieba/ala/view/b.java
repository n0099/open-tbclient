package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b {
    private String eiq;
    private boolean eir;
    private TextView fBh;
    private FrameLayout fBi;
    private HeadImageView fBj;
    private TextView fBk;
    private Context mContext;
    private String mPortrait;
    private View view;

    public b(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.eiq = str;
        this.eir = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.fBh = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.fBi = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.fBj = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.fBk = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.fBj != null) {
            this.fBj.setIsRound(true);
            this.fBj.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
