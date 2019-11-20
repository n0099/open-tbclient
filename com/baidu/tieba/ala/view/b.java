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
    private String dtO;
    private boolean dtP;
    private TextView eCW;
    private FrameLayout eCX;
    private HeadImageView eCY;
    private TextView eCZ;
    private Context mContext;
    private String mPortrait;
    private View view;

    public b(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.dtO = str;
        this.dtP = z;
        this.mPortrait = str2;
        initView();
    }

    public void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_defend_bottom_view, (ViewGroup) null);
        this.eCW = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.eCX = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.eCY = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.eCZ = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        if (this.eCY != null) {
            this.eCY.setIsRound(true);
            this.eCY.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
