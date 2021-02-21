package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class e {
    private String gpR;
    private boolean gpS;
    private TextView iiV;
    private FrameLayout iiW;
    private HeadImageView iiX;
    private TextView iiY;
    private Context mContext;
    private String mPortrait;
    private View view;

    public e(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.gpR = str;
        this.gpS = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.iiV = (TextView) this.view.findViewById(a.f.ala_rank_list_user_rank);
        this.iiW = (FrameLayout) this.view.findViewById(a.f.ala_rank_list_header_layout);
        this.iiX = (HeadImageView) this.view.findViewById(a.f.ala_rank_list_user_header);
        this.iiY = (TextView) this.view.findViewById(a.f.ala_rank_list_user_name);
        if (this.iiX != null) {
            this.iiX.setIsRound(true);
            this.iiX.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
