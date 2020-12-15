package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.bf;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class b extends c {
    public HeadImageView hLw;
    public DrawableTextView hLx;
    public TextView hLy;
    private LinearLayout hLz;

    public b(View view, int i) {
        super(view, i);
        this.hLx = (DrawableTextView) view.findViewById(a.f.attention_btn);
        this.hLw = (HeadImageView) view.findViewById(a.f.user_icon);
        this.hLw.setAutoChangeStyle(false);
        this.hLw.setIsRound(true);
        this.hLy = (TextView) view.findViewById(a.f.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds96)));
        }
        if (i == 2) {
            this.hLz = (LinearLayout) view.findViewById(a.f.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hLx.setVisibility(8);
        } else {
            this.hLx.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(final Object obj) {
        if (obj instanceof bf) {
            bf bfVar = (bf) obj;
            if (bfVar != null) {
                this.hLw.startLoad(bfVar.portrait, 10, false);
                this.hLy.setText(bfVar.getNameShow());
                if (bfVar.aQa == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hLx.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
                        this.hLx.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_person_follow_text_seletor));
                    } else {
                        this.hLx.setBackgroundResource(a.e.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.hLx.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.hLx.setText(this.mRootView.getContext().getString(a.h.ala_person_attention));
                } else {
                    this.hLx.setBackgroundResource(a.e.sdk_unfollow_btn_bg);
                    this.hLx.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10037));
                    this.hLx.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
                }
                if (bfVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hLx.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.hLx.setVisibility(8);
                } else {
                    this.hLx.setVisibility(0);
                }
                if (bfVar.live_status == 1) {
                    if (this.hLz != null) {
                        this.hLz.setVisibility(0);
                    }
                } else if (this.hLz != null) {
                    this.hLz.setVisibility(8);
                }
            }
            this.hLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hJs != null) {
                        b.this.hJs.a((bf) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.hJt != null) {
                            b.this.hJt.b((bf) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.hLy, a.c.sdk_cp_cont_b, 1, i);
    }
}
