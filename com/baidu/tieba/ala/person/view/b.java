package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class b extends c {
    public HeadImageView fmP;
    public DrawableTextView fmQ;
    public TextView fmR;
    private LinearLayout fmS;

    public b(View view, int i) {
        super(view, i);
        this.fmQ = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.fmP = (HeadImageView) view.findViewById(a.g.user_icon);
        this.fmP.setAutoChangeStyle(false);
        this.fmP.setIsRound(true);
        this.fmR = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.fmS = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fmQ.setVisibility(8);
        } else {
            this.fmQ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(final Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.b) {
            com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
            if (bVar != null) {
                this.fmP.startLoad(bVar.portrait, 10, false);
                this.fmR.setText(bVar.getNameShow());
                if (bVar.eGw == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.fmQ.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.fmQ.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.fmQ.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.fmQ.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.fmQ.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.fmQ.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.fmQ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.fmQ.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fmQ.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fmQ.setVisibility(8);
                } else {
                    this.fmQ.setVisibility(0);
                }
                if (bVar.live_status == 1) {
                    if (this.fmS != null) {
                        this.fmS.setVisibility(0);
                    }
                } else if (this.fmS != null) {
                    this.fmS.setVisibility(8);
                }
            }
            this.fmQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fkF != null) {
                        b.this.fkF.a((com.baidu.tieba.ala.person.a.b) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.fkG != null) {
                            b.this.fkG.b((com.baidu.tieba.ala.person.a.b) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.fmR, a.d.sdk_cp_cont_b, 1, i);
    }
}
