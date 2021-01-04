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
    private String grB;
    private boolean grC;
    private TextView iiu;
    private FrameLayout iiv;
    private HeadImageView iiw;
    private TextView iix;
    private Context mContext;
    private String mPortrait;
    private View view;

    public e(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.grB = str;
        this.grC = z;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.iiu = (TextView) this.view.findViewById(a.f.ala_rank_list_user_rank);
        this.iiv = (FrameLayout) this.view.findViewById(a.f.ala_rank_list_header_layout);
        this.iiw = (HeadImageView) this.view.findViewById(a.f.ala_rank_list_user_header);
        this.iix = (TextView) this.view.findViewById(a.f.ala_rank_list_user_name);
        if (this.iiw != null) {
            this.iiw.setIsRound(true);
            this.iiw.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
