package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes3.dex */
public class b {
    private String fff;
    private boolean ffg;
    private TextView gHG;
    private FrameLayout gHH;
    private HeadImageView gHI;
    private TextView gHJ;
    private Context mContext;
    private String mPortrait;
    private View view;

    public b(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.fff = str;
        this.ffg = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.gHG = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.gHH = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.gHI = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.gHJ = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.gHI != null) {
            this.gHI.setIsRound(true);
            this.gHI.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
