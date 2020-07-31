package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class b extends c {
    public HeadImageView gFe;
    public DrawableTextView gFf;
    public TextView gFg;
    private LinearLayout gFh;

    public b(View view, int i) {
        super(view, i);
        this.gFf = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.gFe = (HeadImageView) view.findViewById(a.g.user_icon);
        this.gFe.setAutoChangeStyle(false);
        this.gFe.setIsRound(true);
        this.gFg = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.gFh = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gFf.setVisibility(8);
        } else {
            this.gFf.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void D(final Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.b) {
            com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
            if (bVar != null) {
                this.gFe.startLoad(bVar.portrait, 10, false);
                this.gFg.setText(bVar.getNameShow());
                if (bVar.fVo == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gFf.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.gFf.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.gFf.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.gFf.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.gFf.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.gFf.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.gFf.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.gFf.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gFf.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gFf.setVisibility(8);
                } else {
                    this.gFf.setVisibility(0);
                }
                if (bVar.live_status == 1) {
                    if (this.gFh != null) {
                        this.gFh.setVisibility(0);
                    }
                } else if (this.gFh != null) {
                    this.gFh.setVisibility(8);
                }
            }
            this.gFf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gDc != null) {
                        b.this.gDc.a((com.baidu.tieba.ala.person.a.b) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.gDd != null) {
                            b.this.gDd.b((com.baidu.tieba.ala.person.a.b) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.gFg, a.d.sdk_cp_cont_b, 1, i);
    }
}
