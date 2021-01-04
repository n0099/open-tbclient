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
    private int aMi;
    private String grB;
    private boolean grC;
    private TextView iiY;
    private TextView iiZ;
    private TextView iiu;
    private FrameLayout iiv;
    private HeadImageView iiw;
    private TextView iix;
    private Context mContext;
    private String mPortrait;
    private long mUserId;
    private View view;

    public f(Context context, String str, boolean z, long j, int i, String str2) {
        this.mContext = context;
        this.grB = str;
        this.grC = z;
        this.mUserId = j;
        this.aMi = i;
        this.mPortrait = str2;
        initView();
    }

    private void initView() {
        this.view = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_pk_bottom_view, (ViewGroup) null);
        this.iiu = (TextView) this.view.findViewById(a.f.ala_rank_list_user_rank);
        this.iiv = (FrameLayout) this.view.findViewById(a.f.ala_rank_list_header_layout);
        this.iiw = (HeadImageView) this.view.findViewById(a.f.ala_rank_list_user_header);
        this.iix = (TextView) this.view.findViewById(a.f.ala_rank_list_user_name);
        this.iiY = (TextView) this.view.findViewById(a.f.btn_user_anti_list);
        this.iiZ = (TextView) this.view.findViewById(a.f.btn_user_challenge_history_list);
        this.iiY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(f.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra(UbcStatConstant.KEY_LIVE_TYPE, f.this.aMi);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, f.this.mUserId);
                intent.putExtra("rank_list_type", "guard");
                intent.putExtra("rank_list_from", f.this.grC);
                intent.putExtra("portrait", f.this.mPortrait);
                f.this.mContext.startActivity(intent);
            }
        });
        this.iiZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(f.this.mContext, AlaRankListPKStatusActivity.class);
                intent.putExtra(UbcStatConstant.KEY_LIVE_TYPE, f.this.aMi);
                intent.putExtra(TbEnum.SystemMessage.KEY_USER_ID, f.this.mUserId);
                intent.putExtra("rank_list_type", "challenge_history");
                intent.putExtra("rank_list_from", f.this.grC);
                intent.putExtra("portrait", f.this.mPortrait);
                f.this.mContext.startActivity(intent);
            }
        });
        if (this.iiw != null) {
            this.iiw.setIsRound(true);
            this.iiw.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.view;
    }
}
