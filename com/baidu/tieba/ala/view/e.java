package com.baidu.tieba.ala.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.AlaRankListPKStatusActivity;
/* loaded from: classes7.dex */
public class e {
    private int aED;
    private String fvE;
    private boolean fvF;
    private TextView haG;
    private TextView haH;
    private TextView hac;
    private FrameLayout had;
    private HeadImageView hae;
    private TextView haf;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public e(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.fvE = str;
        this.fvF = z;
        this.mUserId = j;
        this.aED = i;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.hac = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.had = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.hae = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.haf = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.haG = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.haH = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.haG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(e.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", e.this.aED);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, e.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", e.this.fvF);
                intent.putExtra("portrait", e.this.mPortrait);
                e.this.mContext.startActivity(intent);
            }
        });
        this.haH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(e.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", e.this.aED);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, e.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", e.this.fvF);
                intent.putExtra("portrait", e.this.mPortrait);
                e.this.mContext.startActivity(intent);
            }
        });
        if (this.hae != null) {
            this.hae.setIsRound(true);
            this.hae.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
