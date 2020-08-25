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
    public HeadImageView gRG;
    public DrawableTextView gRH;
    public TextView gRI;
    private LinearLayout gRJ;

    public b(View view, int i) {
        super(view, i);
        this.gRH = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.gRG = (HeadImageView) view.findViewById(a.g.user_icon);
        this.gRG.setAutoChangeStyle(false);
        this.gRG.setIsRound(true);
        this.gRI = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.gRJ = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gRH.setVisibility(8);
        } else {
            this.gRH.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void F(final Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.b) {
            com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
            if (bVar != null) {
                this.gRG.startLoad(bVar.portrait, 10, false);
                this.gRI.setText(bVar.getNameShow());
                if (bVar.ghn == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gRH.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.gRH.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.gRH.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.gRH.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.gRH.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.gRH.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.gRH.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.gRH.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gRH.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gRH.setVisibility(8);
                } else {
                    this.gRH.setVisibility(0);
                }
                if (bVar.live_status == 1) {
                    if (this.gRJ != null) {
                        this.gRJ.setVisibility(0);
                    }
                } else if (this.gRJ != null) {
                    this.gRJ.setVisibility(8);
                }
            }
            this.gRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gPB != null) {
                        b.this.gPB.a((com.baidu.tieba.ala.person.a.b) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.gPC != null) {
                            b.this.gPC.b((com.baidu.tieba.ala.person.a.b) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.gRI, a.d.sdk_cp_cont_b, 1, i);
    }
}
