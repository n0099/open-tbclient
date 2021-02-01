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
    private String gpD;
    private boolean gpE;
    private TextView iiH;
    private FrameLayout iiI;
    private HeadImageView iiJ;
    private TextView iiK;
    private Context mContext;
    private String mPortrait;
    private View view;

    public e(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.gpD = str;
        this.gpE = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.iiH = (TextView) this.view.findViewById(a.f.ala_rank_list_user_rank);
        this.iiI = (FrameLayout) this.view.findViewById(a.f.ala_rank_list_header_layout);
        this.iiJ = (HeadImageView) this.view.findViewById(a.f.ala_rank_list_user_header);
        this.iiK = (TextView) this.view.findViewById(a.f.ala_rank_list_user_name);
        if (this.iiJ != null) {
            this.iiJ.setIsRound(true);
            this.iiJ.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
