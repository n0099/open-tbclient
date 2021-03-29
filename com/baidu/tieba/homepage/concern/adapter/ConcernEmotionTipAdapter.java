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
import d.b.b.j.e.a;
import d.b.i0.z0.b.f.b;
/* loaded from: classes3.dex */
public class ConcernEmotionTipAdapter extends a<b, ConcernEmotionTipViewHolder> {

    /* loaded from: classes3.dex */
    public static class ConcernEmotionTipViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f17001a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f17002b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17003c;

        /* renamed from: d  reason: collision with root package name */
        public int f17004d;

        public ConcernEmotionTipViewHolder(View view) {
            super(view);
            this.f17004d = 3;
            this.f17001a = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.f17002b = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.f17003c = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        public void b(int i, int i2) {
            if (this.f17004d != i) {
                SkinManager.setViewTextColor(this.f17003c, R.color.CAM_X0107);
            }
            SkinManager.setImageResource(this.f17002b, i2);
            this.f17004d = i;
        }
    }

    public ConcernEmotionTipAdapter(Context context) {
        super(context, b.k);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public ConcernEmotionTipViewHolder R(ViewGroup viewGroup) {
        return new ConcernEmotionTipViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, ConcernEmotionTipViewHolder concernEmotionTipViewHolder) {
        String str = bVar.f62791f;
        if (str != null) {
            concernEmotionTipViewHolder.f17003c.setText(str);
        }
        if (bVar.getType() == b.j) {
            if (bVar.f62790e == 2) {
                concernEmotionTipViewHolder.f17003c.setText(TbadkCoreApplication.getInst().getString(R.string.concern_person_no_data_title));
            } else {
                concernEmotionTipViewHolder.f17003c.setText(TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title));
            }
        }
        int i2 = bVar.f62790e;
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
