package com.baidu.tieba.ala.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.AlaRankListPKStatusActivity;
/* loaded from: classes3.dex */
public class c {
    private int avX;
    private String eUU;
    private boolean eUV;
    private TextView guS;
    private FrameLayout guT;
    private HeadImageView guU;
    private TextView guV;
    private TextView gvw;
    private TextView gvx;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public c(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.eUU = str;
        this.eUV = z;
        this.mUserId = j;
        this.avX = i;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.guS = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.guT = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.guU = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.guV = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.gvw = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.gvx = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.gvw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.avX);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", c.this.eUV);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        this.gvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.avX);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", c.this.eUV);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        if (this.guU != null) {
            this.guU.setIsRound(true);
            this.guU.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
