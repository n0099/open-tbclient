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
public class d {
    private String fki;
    private boolean fkj;
    private TextView gNm;
    private FrameLayout gNn;
    private HeadImageView gNo;
    private TextView gNp;
    private Context mContext;
    private String mPortrait;
    private View view;

    public d(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.fki = str;
        this.fkj = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.gNm = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.gNn = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.gNo = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.gNp = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.gNo != null) {
            this.gNo.setIsRound(true);
            this.gNo.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
