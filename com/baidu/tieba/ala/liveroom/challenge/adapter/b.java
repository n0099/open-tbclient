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
    public String hju;
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
            view = LayoutInflater.from(this.mContext).inflate(a.g.layout_item_mvp_choose_punish, (ViewGroup) null);
            a aVar2 = new a(view);
            aVar2.hjv.setDefaultBgResource(a.e.sdk_shape_transparent);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.tieba.ala.liveroom.challenge.a.b bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) getItem(i);
        if (bVar != null) {
            aVar.hjv.startLoad(bVar.bgurl, 10, false);
            if (TextUtils.equals(this.hju, bVar.id)) {
                aVar.hjw.setImageResource(a.e.icon_mvp_choose_punish_check);
            } else {
                aVar.hjw.setImageResource(a.e.icon_mvp_choose_punish_not_check);
            }
            aVar.hjx.setText(bVar.name);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TbImageView hjv;
        public ImageView hjw;
        public TextView hjx;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hjv = (TbImageView) view.findViewById(a.f.sticker_imageView);
            this.hjw = (ImageView) view.findViewById(a.f.check_imageView);
            this.hjx = (TextView) view.findViewById(a.f.stickerName_textView);
        }
    }
}
