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
    private String eIk;
    private boolean eIl;
    private TextView gfO;
    private FrameLayout gfP;
    private HeadImageView gfQ;
    private TextView gfR;
    private Context mContext;
    private String mPortrait;
    private View view;

    public b(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.eIk = str;
        this.eIl = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.gfO = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.gfP = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.gfQ = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.gfR = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.gfQ != null) {
            this.gfQ.setIsRound(true);
            this.gfQ.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
