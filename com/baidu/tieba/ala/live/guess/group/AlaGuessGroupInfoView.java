package com.baidu.tieba.ala.live.guess.group;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class AlaGuessGroupInfoView extends LinearLayout {
    private TextView aWL;
    private HeadImageView hip;
    private ImageView hiq;
    private ImageView hir;

    public AlaGuessGroupInfoView(Context context) {
        super(context);
        init(context);
    }

    public AlaGuessGroupInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaGuessGroupInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_guess_person_info_view, this);
        this.hip = (HeadImageView) findViewById(a.f.head_info);
        this.aWL = (TextView) findViewById(a.f.tv_username);
        this.hiq = (ImageView) findViewById(a.f.img_user_status);
        this.hir = (ImageView) findViewById(a.f.img_ticket);
        this.hip.setIsRound(true);
        this.hip.setAutoChangeStyle(false);
        this.hip.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    public void setNickName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aWL.setText(str);
        }
    }

    public void setHeadImage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hip.startLoad(str, 10, true);
        }
    }

    public void setStatusImage(int i) {
        this.hiq.setImageResource(i);
    }

    public void setTickImage(int i) {
        this.hir.setImageResource(i);
    }

    public HeadImageView getHeadImage() {
        return this.hip;
    }

    public TextView getNickName() {
        return this.aWL;
    }

    public ImageView getStatusImage() {
        return this.hiq;
    }

    public ImageView getTickImage() {
        return this.hir;
    }
}
