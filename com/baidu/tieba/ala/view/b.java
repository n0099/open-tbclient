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
    private String eIf;
    private boolean eIg;
    private TextView gfI;
    private FrameLayout gfJ;
    private HeadImageView gfK;
    private TextView gfL;
    private Context mContext;
    private String mPortrait;
    private View view;

    public b(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.eIf = str;
        this.eIg = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.gfI = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.gfJ = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.gfK = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.gfL = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.gfK != null) {
            this.gfK.setIsRound(true);
            this.gfK.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
