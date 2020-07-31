package com.baidu.tieba.ala.liveroom.guideim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class GuideImInputView extends FrameLayout {
    private TextView gnY;
    private a gnZ;

    /* loaded from: classes4.dex */
    public interface a {
        void DI(String str);
    }

    public GuideImInputView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gnZ = aVar;
    }

    public void setText(String str) {
        this.gnY.setText(str);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.guide_im_input, (ViewGroup) this, true);
        this.gnY = (TextView) findViewById(a.g.tv_input);
        TextView textView = (TextView) findViewById(a.g.tv_send);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuideImInputView.this.gnZ != null) {
                    GuideImInputView.this.gnZ.DI(GuideImInputView.this.gnY.getText().toString());
                }
            }
        });
    }
}
