package com.baidu.tieba.ala.live.guess.result;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.data.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class AlaGuessSingleBottomCenterView extends FrameLayout {
    private HeadImageView hht;
    private TextView hhu;
    private TextView hhv;

    public AlaGuessSingleBottomCenterView(Context context) {
        super(context);
        init(context);
    }

    public AlaGuessSingleBottomCenterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaGuessSingleBottomCenterView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_guess_single_bottom_center_view, this);
        this.hht = (HeadImageView) findViewById(a.f.img_second_icon);
        c(this.hht);
        this.hhu = (TextView) findViewById(a.f.txt_second_center_content);
        this.hhv = (TextView) findViewById(a.f.txt_second_last_money);
    }

    private void c(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    public void setData(o.c cVar) {
        this.hhu.setText(cVar.getTips());
        this.hht.startLoad(cVar.getIcon(), 10, false);
        this.hhv.setText(" " + cVar.BR() + "元");
    }

    public void setSpecialUI() {
        this.hht.setVisibility(8);
        this.hhv.setVisibility(8);
        this.hhu.setText(getResources().getString(a.h.ala_guess_result_single_bottomview_empty_tips));
    }
}
