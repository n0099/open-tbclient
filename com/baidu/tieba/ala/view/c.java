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
/* loaded from: classes3.dex */
public class c {
    private int ayf;
    private String fff;
    private boolean ffg;
    private TextView gHG;
    private FrameLayout gHH;
    private HeadImageView gHI;
    private TextView gHJ;
    private TextView gIk;
    private TextView gIl;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public c(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.fff = str;
        this.ffg = z;
        this.mUserId = j;
        this.ayf = i;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.gHG = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.gHH = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.gHI = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.gHJ = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.gIk = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.gIl = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.gIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.ayf);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", c.this.ffg);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        this.gIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.ayf);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", c.this.ffg);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        if (this.gHI != null) {
            this.gHI.setIsRound(true);
            this.gHI.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
