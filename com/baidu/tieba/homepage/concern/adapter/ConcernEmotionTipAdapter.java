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
import d.a.c.j.e.a;
import d.a.k0.a1.b.f.b;
/* loaded from: classes4.dex */
public class ConcernEmotionTipAdapter extends a<b, ConcernEmotionTipViewHolder> {

    /* loaded from: classes4.dex */
    public static class ConcernEmotionTipViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f16249a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f16250b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16251c;

        /* renamed from: d  reason: collision with root package name */
        public int f16252d;

        public ConcernEmotionTipViewHolder(View view) {
            super(view);
            this.f16252d = 3;
            this.f16249a = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.f16250b = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.f16251c = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        public void b(int i2, int i3) {
            if (this.f16252d != i2) {
                SkinManager.setViewTextColor(this.f16251c, R.color.CAM_X0107);
            }
            SkinManager.setImageResource(this.f16250b, i3);
            this.f16252d = i2;
        }
    }

    public ConcernEmotionTipAdapter(Context context) {
        super(context, b.k);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public ConcernEmotionTipViewHolder P(ViewGroup viewGroup) {
        return new ConcernEmotionTipViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, b bVar, ConcernEmotionTipViewHolder concernEmotionTipViewHolder) {
        String str = bVar.f51222f;
        if (str != null) {
            concernEmotionTipViewHolder.f16251c.setText(str);
        }
        if (bVar.getType() == b.j) {
            if (bVar.f51221e == 2) {
                concernEmotionTipViewHolder.f16251c.setText(TbadkCoreApplication.getInst().getString(R.string.concern_person_no_data_title));
            } else {
                concernEmotionTipViewHolder.f16251c.setText(TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title));
            }
        }
        int i3 = bVar.f51221e;
        if (i3 == 2) {
            concernEmotionTipViewHolder.b(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
        } else if (i3 == 3) {
            concernEmotionTipViewHolder.b(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
        }
        return concernEmotionTipViewHolder.a();
    }

    public ConcernEmotionTipAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }
}
