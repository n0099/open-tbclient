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
    private String eUJ;
    private boolean eUK;
    private TextView guH;
    private FrameLayout guI;
    private HeadImageView guJ;
    private TextView guK;
    private Context mContext;
    private String mPortrait;
    private View view;

    public b(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.eUJ = str;
        this.eUK = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.guH = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.guI = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.guJ = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.guK = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.guJ != null) {
            this.guJ.setIsRound(true);
            this.guJ.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
