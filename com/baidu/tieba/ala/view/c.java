package com.baidu.tieba.ala.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.AlaRankListPKStatusActivity;
/* loaded from: classes2.dex */
public class c {
    private int Ws;
    private String edB;
    private boolean edC;
    private TextView fuB;
    private FrameLayout fuC;
    private HeadImageView fuD;
    private TextView fuE;
    private TextView fvf;
    private TextView fvg;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public c(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.edB = str;
        this.edC = z;
        this.mUserId = j;
        this.Ws = i;
        this.mPortrait = str2;
        initView();
    }

    public void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.fuB = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.fuC = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.fuD = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.fuE = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.fvf = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.fvg = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.fvf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.Ws);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", c.this.edC);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        this.fvg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.Ws);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", c.this.edC);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        if (this.fuD != null) {
            this.fuD.setIsRound(true);
            this.fuD.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
