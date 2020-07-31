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
/* loaded from: classes4.dex */
public class e {
    private int azs;
    private String fki;
    private boolean fkj;
    private TextView gNQ;
    private TextView gNR;
    private TextView gNm;
    private FrameLayout gNn;
    private HeadImageView gNo;
    private TextView gNp;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public e(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.fki = str;
        this.fkj = z;
        this.mUserId = j;
        this.azs = i;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.gNm = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.gNn = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.gNo = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.gNp = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.gNQ = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.gNR = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.gNQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(e.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", e.this.azs);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, e.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", e.this.fkj);
                intent.putExtra("portrait", e.this.mPortrait);
                e.this.mContext.startActivity(intent);
            }
        });
        this.gNR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(e.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", e.this.azs);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, e.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", e.this.fkj);
                intent.putExtra("portrait", e.this.mPortrait);
                e.this.mContext.startActivity(intent);
            }
        });
        if (this.gNo != null) {
            this.gNo.setIsRound(true);
            this.gNo.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
