package com.baidu.tieba.ala.live.guess.result;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.live.data.o;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.live.guess.group.AlaGuessGroupInfoView;
import com.baidu.tieba.ala.live.guess.group.AlaGuessGroupView;
import java.util.List;
/* loaded from: classes11.dex */
public class AlaGuessGroupBottomView extends FrameLayout {
    private AlaGuessGroupView hgZ;

    public AlaGuessGroupBottomView(Context context) {
        super(context);
        init(context);
    }

    public AlaGuessGroupBottomView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaGuessGroupBottomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_guess_group_bottom_view, this);
        this.hgZ = (AlaGuessGroupView) findViewById(a.f.group_bottom_view);
    }

    public void setData(int i, List<o.b> list) {
        if (this.hgZ != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 == 0) {
                    a(i, this.hgZ.getFirstInfo(), list.get(0));
                } else if (i2 == 1) {
                    a(i, this.hgZ.getSecondInfo(), list.get(1));
                } else if (i2 == 2) {
                    a(i, this.hgZ.getThirdInfo(), list.get(2));
                }
            }
        }
    }

    private void a(int i, AlaGuessGroupInfoView alaGuessGroupInfoView, o.b bVar) {
        if (alaGuessGroupInfoView != null && bVar != null) {
            alaGuessGroupInfoView.setHeadImage(bVar.getAvatar());
            alaGuessGroupInfoView.setNickName(j.K(bVar.getNickname(), 8));
            int BP = bVar.BP();
            if (BP == 3) {
                alaGuessGroupInfoView.setStatusImage(a.e.ala_guess_state_unanswer);
            } else if (i == BP) {
                alaGuessGroupInfoView.setStatusImage(a.e.ala_guess_state_right);
            } else {
                alaGuessGroupInfoView.setStatusImage(a.e.ala_guess_state_error);
            }
            if (bVar.BQ() == 1) {
                alaGuessGroupInfoView.getTickImage().setVisibility(0);
            } else {
                alaGuessGroupInfoView.getTickImage().setVisibility(4);
            }
        }
    }

    public void setLeftRightMarging(float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hgZ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = (int) f;
            layoutParams.rightMargin = (int) f;
        }
    }

    public void setUIStyle() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hgZ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) getResources().getDimension(a.d.sdk_ds440);
            layoutParams.gravity = 1;
        }
    }
}
