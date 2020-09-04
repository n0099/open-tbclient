package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes7.dex */
public class b extends c {
    public HeadImageView gRK;
    public DrawableTextView gRL;
    public TextView gRM;
    private LinearLayout gRN;

    public b(View view, int i) {
        super(view, i);
        this.gRL = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.gRK = (HeadImageView) view.findViewById(a.g.user_icon);
        this.gRK.setAutoChangeStyle(false);
        this.gRK.setIsRound(true);
        this.gRM = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.gRN = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gRL.setVisibility(8);
        } else {
            this.gRL.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void F(final Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.b) {
            com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
            if (bVar != null) {
                this.gRK.startLoad(bVar.portrait, 10, false);
                this.gRM.setText(bVar.getNameShow());
                if (bVar.ghr == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gRL.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.gRL.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.gRL.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.gRL.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.gRL.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.gRL.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.gRL.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.gRL.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gRL.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gRL.setVisibility(8);
                } else {
                    this.gRL.setVisibility(0);
                }
                if (bVar.live_status == 1) {
                    if (this.gRN != null) {
                        this.gRN.setVisibility(0);
                    }
                } else if (this.gRN != null) {
                    this.gRN.setVisibility(8);
                }
            }
            this.gRL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gPF != null) {
                        b.this.gPF.a((com.baidu.tieba.ala.person.a.b) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.gPG != null) {
                            b.this.gPG.b((com.baidu.tieba.ala.person.a.b) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.gRM, a.d.sdk_cp_cont_b, 1, i);
    }
}
