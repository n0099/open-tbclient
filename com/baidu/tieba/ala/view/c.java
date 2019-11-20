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
    private int Pw;
    private String dtO;
    private boolean dtP;
    private TextView eCW;
    private FrameLayout eCX;
    private HeadImageView eCY;
    private TextView eCZ;
    private TextView eDA;
    private TextView eDB;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public c(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.dtO = str;
        this.dtP = z;
        this.mUserId = j;
        this.Pw = i;
        this.mPortrait = str2;
        initView();
    }

    public void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.eCW = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.eCX = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.eCY = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.eCZ = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.eDA = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.eDB = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.eDA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.Pw);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", c.this.dtP);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        this.eDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(c.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra("live_type", c.this.Pw);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, c.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", c.this.dtP);
                intent.putExtra("portrait", c.this.mPortrait);
                c.this.mContext.startActivity(intent);
            }
        });
        if (this.eCY != null) {
            this.eCY.setIsRound(true);
            this.eCY.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
