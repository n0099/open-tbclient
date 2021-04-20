package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.j.e.a;
import d.b.i0.a1.b.f.b;
/* loaded from: classes4.dex */
public class ConcernEmotionTipAdapter extends a<b, ConcernEmotionTipViewHolder> {

    /* loaded from: classes4.dex */
    public static class ConcernEmotionTipViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f16674a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f16675b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16676c;

        /* renamed from: d  reason: collision with root package name */
        public int f16677d;

        public ConcernEmotionTipViewHolder(View view) {
            super(view);
            this.f16677d = 3;
            this.f16674a = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.f16675b = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.f16676c = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        public void b(int i, int i2) {
            if (this.f16677d != i) {
                SkinManager.setViewTextColor(this.f16676c, R.color.CAM_X0107);
            }
            SkinManager.setImageResource(this.f16675b, i2);
            this.f16677d = i;
        }
    }

    public ConcernEmotionTipAdapter(Context context) {
        super(context, b.k);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public ConcernEmotionTipViewHolder R(ViewGroup viewGroup) {
        return new ConcernEmotionTipViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, ConcernEmotionTipViewHolder concernEmotionTipViewHolder) {
        String str = bVar.f52410f;
        if (str != null) {
            concernEmotionTipViewHolder.f16676c.setText(str);
        }
        if (bVar.getType() == b.j) {
            if (bVar.f52409e == 2) {
                concernEmotionTipViewHolder.f16676c.setText(TbadkCoreApplication.getInst().getString(R.string.concern_person_no_data_title));
            } else {
                concernEmotionTipViewHolder.f16676c.setText(TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title));
            }
        }
        int i2 = bVar.f52409e;
        if (i2 == 2) {
            concernEmotionTipViewHolder.b(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
        } else if (i2 == 3) {
            concernEmotionTipViewHolder.b(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
        }
        return concernEmotionTipViewHolder.a();
    }

    public ConcernEmotionTipAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }
}
