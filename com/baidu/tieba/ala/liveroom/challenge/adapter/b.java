package com.baidu.tieba.ala.liveroom.challenge.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private List<com.baidu.tieba.ala.liveroom.challenge.a.b> dataList;
    public String gek;
    private Context mContext;

    public b(Context context, List<com.baidu.tieba.ala.liveroom.challenge.a.b> list) {
        this.mContext = context;
        this.dataList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dataList == null) {
            return 0;
        }
        return this.dataList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dataList == null) {
            return null;
        }
        return this.dataList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.layout_item_mvp_choose_punish, (ViewGroup) null);
            a aVar2 = new a(view);
            aVar2.gel.setDefaultBgResource(a.f.sdk_shape_transparent);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.b bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) getItem(i);
        if (bVar != null) {
            aVar.gel.startLoad(bVar.bgurl, 10, false);
            if (TextUtils.equals(this.gek, bVar.id)) {
                aVar.gem.setImageResource(a.f.icon_mvp_choose_punish_check);
            } else {
                aVar.gem.setImageResource(a.f.icon_mvp_choose_punish_not_check);
            }
            aVar.gen.setText(bVar.name);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TbImageView gel;
        public ImageView gem;
        public TextView gen;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gel = (TbImageView) view.findViewById(a.g.sticker_imageView);
            this.gem = (ImageView) view.findViewById(a.g.check_imageView);
            this.gen = (TextView) view.findViewById(a.g.stickerName_textView);
        }
    }
}
