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
/* loaded from: classes11.dex */
public class AlaGuessGroupInfoView extends LinearLayout {
    private TextView aVl;
    private HeadImageView hgr;
    private ImageView hgs;
    private ImageView hgt;

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
        this.hgr = (HeadImageView) findViewById(a.f.head_info);
        this.aVl = (TextView) findViewById(a.f.tv_username);
        this.hgs = (ImageView) findViewById(a.f.img_user_status);
        this.hgt = (ImageView) findViewById(a.f.img_ticket);
        this.hgr.setIsRound(true);
        this.hgr.setAutoChangeStyle(false);
        this.hgr.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    public void setNickName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aVl.setText(str);
        }
    }

    public void setHeadImage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hgr.startLoad(str, 10, true);
        }
    }

    public void setStatusImage(int i) {
        this.hgs.setImageResource(i);
    }

    public void setTickImage(int i) {
        this.hgt.setImageResource(i);
    }

    public HeadImageView getHeadImage() {
        return this.hgr;
    }

    public TextView getNickName() {
        return this.aVl;
    }

    public ImageView getStatusImage() {
        return this.hgs;
    }

    public ImageView getTickImage() {
        return this.hgt;
    }
}
