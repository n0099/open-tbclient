package com.baidu.tieba.ala.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.AlaRankListPKStatusActivity;
/* loaded from: classes6.dex */
public class c {
    private int Qc;
    private String duF;
    private boolean duG;
    private TextView eDN;
    private FrameLayout eDO;
    private HeadImageView eDP;
    private TextView eDQ;
    private TextView eEr;
    private TextView eEs;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public c(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.duF = str;
        this.duG = z;
        this.mUserId = j;
        this.Qc = i;
        this.mPortrait = str2;
        initView();
    }

    public void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.eDN = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.eDO = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.eDP = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.eDQ = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.eEr = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.eEs = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.eEr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.Qc);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", c.this.duG);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        this.eEs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.Qc);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", c.this.duG);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        if (this.eDP != null) {
            this.eDP.setIsRound(true);
            this.eDP.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
