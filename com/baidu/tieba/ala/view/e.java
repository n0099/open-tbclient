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
    private int aEF;
    private String fvI;
    private boolean fvJ;
    private TextView haK;
    private TextView haL;
    private TextView hag;
    private FrameLayout hah;
    private HeadImageView hai;
    private TextView haj;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public e(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.fvI = str;
        this.fvJ = z;
        this.mUserId = j;
        this.aEF = i;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.hag = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.hah = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.hai = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.haj = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.haK = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.haL = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.haK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(e.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", e.this.aEF);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, e.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", e.this.fvJ);
                intent.putExtra("portrait", e.this.mPortrait);
                e.this.mContext.startActivity(intent);
            }
        });
        this.haL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(e.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", e.this.aEF);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, e.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", e.this.fvJ);
                intent.putExtra("portrait", e.this.mPortrait);
                e.this.mContext.startActivity(intent);
            }
        });
        if (this.hai != null) {
            this.hai.setIsRound(true);
            this.hai.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
