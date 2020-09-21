package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.az;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class b extends c {
    public HeadImageView gVs;
    public DrawableTextView gVt;
    public TextView gVu;
    private LinearLayout gVv;

    public b(View view, int i) {
        super(view, i);
        this.gVt = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.gVs = (HeadImageView) view.findViewById(a.g.user_icon);
        this.gVs.setAutoChangeStyle(false);
        this.gVs.setIsRound(true);
        this.gVu = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.gVv = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gVt.setVisibility(8);
        } else {
            this.gVt.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void G(final Object obj) {
        if (obj instanceof az) {
            az azVar = (az) obj;
            if (azVar != null) {
                this.gVs.startLoad(azVar.portrait, 10, false);
                this.gVu.setText(azVar.getNameShow());
                if (azVar.aJZ == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gVt.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.gVt.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.gVt.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.gVt.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.gVt.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.gVt.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.gVt.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.gVt.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (azVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gVt.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gVt.setVisibility(8);
                } else {
                    this.gVt.setVisibility(0);
                }
                if (azVar.live_status == 1) {
                    if (this.gVv != null) {
                        this.gVv.setVisibility(0);
                    }
                } else if (this.gVv != null) {
                    this.gVv.setVisibility(8);
                }
            }
            this.gVt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gTn != null) {
                        b.this.gTn.a((az) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.gTo != null) {
                            b.this.gTo.b((az) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.gVu, a.d.sdk_cp_cont_b, 1, i);
    }
}
