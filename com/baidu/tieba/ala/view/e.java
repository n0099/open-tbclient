package com.baidu.tieba.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class e {
    private String gmU;
    private boolean gmV;
    private TextView idN;
    private FrameLayout idO;
    private HeadImageView idP;
    private TextView idQ;
    private Context mContext;
    private String mPortrait;
    private View view;

    public e(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.gmU = str;
        this.gmV = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.idN = (TextView) this.view.findViewById(a.f.ala_rank_list_user_rank);
        this.idO = (FrameLayout) this.view.findViewById(a.f.ala_rank_list_header_layout);
        this.idP = (HeadImageView) this.view.findViewById(a.f.ala_rank_list_user_header);
        this.idQ = (TextView) this.view.findViewById(a.f.ala_rank_list_user_name);
        if (this.idP != null) {
            this.idP.setIsRound(true);
            this.idP.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
