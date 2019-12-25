package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class b {
    private String edB;
    private boolean edC;
    private TextView fuB;
    private FrameLayout fuC;
    private HeadImageView fuD;
    private TextView fuE;
    private Context mContext;
    private String mPortrait;
    private View view;

    public b(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.edB = str;
        this.edC = z;
        this.mPortrait = str2;
        initView();
    }

    public void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.fuB = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.fuC = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.fuD = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.fuE = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.fuD != null) {
            this.fuD.setIsRound(true);
            this.fuD.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
