package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class b extends c {
    public HeadImageView fpZ;
    public DrawableTextView fqa;
    public TextView fqb;
    private LinearLayout fqc;

    public b(View view, int i) {
        super(view, i);
        this.fqa = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.fpZ = (HeadImageView) view.findViewById(a.g.user_icon);
        this.fpZ.setAutoChangeStyle(false);
        this.fpZ.setIsRound(true);
        this.fqb = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.fqc = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fqa.setVisibility(8);
        } else {
            this.fqa.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(final Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.b) {
            com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
            if (bVar != null) {
                this.fpZ.startLoad(bVar.portrait, 10, false);
                this.fqb.setText(bVar.getNameShow());
                if (bVar.eHG == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.fqa.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.fqa.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.fqa.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.fqa.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.fqa.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.fqa.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.fqa.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.fqa.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fqa.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fqa.setVisibility(8);
                } else {
                    this.fqa.setVisibility(0);
                }
                if (bVar.live_status == 1) {
                    if (this.fqc != null) {
                        this.fqc.setVisibility(0);
                    }
                } else if (this.fqc != null) {
                    this.fqc.setVisibility(8);
                }
            }
            this.fqa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fnP != null) {
                        b.this.fnP.a((com.baidu.tieba.ala.person.a.b) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.fnQ != null) {
                            b.this.fnQ.b((com.baidu.tieba.ala.person.a.b) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.fqb, a.d.sdk_cp_cont_b, 1, i);
    }
}
