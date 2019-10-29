package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class b {
    private String duF;
    private boolean duG;
    private TextView eDN;
    private FrameLayout eDO;
    private HeadImageView eDP;
    private TextView eDQ;
    private Context mContext;
    private String mPortrait;
    private View view;

    public b(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.duF = str;
        this.duG = z;
        this.mPortrait = str2;
        initView();
    }

    public void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.eDN = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.eDO = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.eDP = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.eDQ = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.eDP != null) {
            this.eDP.setIsRound(true);
            this.eDP.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
