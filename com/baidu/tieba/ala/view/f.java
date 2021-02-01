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
/* loaded from: classes11.dex */
public class f {
    private int aKa;
    private String gpD;
    private boolean gpE;
    private TextView iiH;
    private FrameLayout iiI;
    private HeadImageView iiJ;
    private TextView iiK;
    private TextView ijl;
    private TextView ijm;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public f(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.gpD = str;
        this.gpE = z;
        this.mUserId = j;
        this.aKa = i;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.iiH = (TextView) this.view.findViewById(a.f.ala_rank_list_user_rank);
        this.iiI = (FrameLayout) this.view.findViewById(a.f.ala_rank_list_header_layout);
        this.iiJ = (HeadImageView) this.view.findViewById(a.f.ala_rank_list_user_header);
        this.iiK = (TextView) this.view.findViewById(a.f.ala_rank_list_user_name);
        this.ijl = (TextView) this.view.findViewById(a.f.btn_user_anti_list);
        this.ijm = (TextView) this.view.findViewById(a.f.btn_user_challenge_history_list);
        this.ijl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(f.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra(UbcStatConstant.KEY_LIVE_TYPE, f.this.aKa);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, f.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", f.this.gpE);
                intent.putExtra("portrait", f.this.mPortrait);
                f.this.mContext.startActivity(intent);
            }
        });
        this.ijm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(f.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra(UbcStatConstant.KEY_LIVE_TYPE, f.this.aKa);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, f.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", f.this.gpE);
                intent.putExtra("portrait", f.this.mPortrait);
                f.this.mContext.startActivity(intent);
            }
        });
        if (this.iiJ != null) {
            this.iiJ.setIsRound(true);
            this.iiJ.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
