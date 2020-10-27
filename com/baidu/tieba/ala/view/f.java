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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tieba.ala.AlaRankListPKStatusActivity;
/* loaded from: classes4.dex */
public class f {
    private int aJw;
    private String fTt;
    private boolean fTu;
    private TextView hFY;
    private TextView hFZ;
    private TextView hFu;
    private FrameLayout hFv;
    private HeadImageView hFw;
    private TextView hFx;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public f(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.fTt = str;
        this.fTu = z;
        this.mUserId = j;
        this.aJw = i;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.hFu = (TextView) this.view.findViewById(a.g.ala_rank_list_user_rank);
        this.hFv = (FrameLayout) this.view.findViewById(a.g.ala_rank_list_header_layout);
        this.hFw = (HeadImageView) this.view.findViewById(a.g.ala_rank_list_user_header);
        this.hFx = (TextView) this.view.findViewById(a.g.ala_rank_list_user_name);
        this.hFY = (TextView) this.view.findViewById(a.g.btn_user_anti_list);
        this.hFZ = (TextView) this.view.findViewById(a.g.btn_user_challenge_history_list);
        this.hFY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(f.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra(UbcStatConstant.KEY_LIVE_TYPE, f.this.aJw);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, f.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", f.this.fTu);
                intent.putExtra("portrait", f.this.mPortrait);
                f.this.mContext.startActivity(intent);
            }
        });
        this.hFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(f.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra(UbcStatConstant.KEY_LIVE_TYPE, f.this.aJw);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, f.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", f.this.fTu);
                intent.putExtra("portrait", f.this.mPortrait);
                f.this.mContext.startActivity(intent);
            }
        });
        if (this.hFw != null) {
            this.hFw.setIsRound(true);
            this.hFw.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
