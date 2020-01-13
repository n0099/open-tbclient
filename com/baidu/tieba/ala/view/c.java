package com.baidu.tieba.ala.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.AlaRankListPKStatusActivity;
/* loaded from: classes2.dex */
public class c {
    private int WL;
    private String edJ;
    private boolean edK;
    private TextView fxM;
    private FrameLayout fxN;
    private HeadImageView fxO;
    private TextView fxP;
    private TextView fyq;
    private TextView fyr;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public c(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.edJ = str;
        this.edK = z;
        this.mUserId = j;
        this.WL = i;
        this.mPortrait = str2;
        initView();
    }

    public void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.fxM = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.fxN = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.fxO = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.fxP = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.fyq = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.fyr = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.fyq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.WL);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", c.this.edK);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        this.fyr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.WL);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", c.this.edK);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        if (this.fxO != null) {
            this.fxO.setIsRound(true);
            this.fxO.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
