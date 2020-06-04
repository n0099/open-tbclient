package com.baidu.tieba.ala.liveroom.recommend.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends AbsDelegateAdapter<com.baidu.tieba.ala.liveroom.recommend.data.b, a> {
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: ax */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_type_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.recommend.data.b bVar, a aVar) {
        float dimensionPixelSize;
        String string;
        switch (bVar.type) {
            case 0:
                dimensionPixelSize = aVar.getView().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                string = this.mContext.getString(a.i.recommend_live_attention, String.valueOf(bVar.count));
                break;
            default:
                dimensionPixelSize = aVar.getView().getResources().getDimensionPixelSize(a.e.sdk_ds80);
                string = this.mContext.getString(a.i.recommend_live_recommend);
                break;
        }
        aVar.gdN.getPaint().setShader(new LinearGradient(0.0f, 0.0f, dimensionPixelSize, 0.0f, Color.parseColor("#FF1E66"), Color.parseColor("#FF6619"), Shader.TileMode.CLAMP));
        aVar.gdN.setText(string);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private TextView gdN;

        private a(View view) {
            super(view);
            this.gdN = (TextView) view.findViewById(a.g.ala_recommend_live_type);
        }
    }
}
