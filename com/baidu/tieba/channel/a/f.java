package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends BaseAdapter {
    private ChannelListActivity enV;
    private List<com.baidu.tieba.channel.data.f> mData;

    public f(ChannelListActivity channelListActivity) {
        this.enV = channelListActivity;
    }

    public void setData(List<com.baidu.tieba.channel.data.f> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ox */
    public com.baidu.tieba.channel.data.f getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.enV.getPageContext().getPageActivity()).inflate(d.h.channel_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.enW = (TbImageView) view.findViewById(d.g.channel_avatar);
            aVar2.enW.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
            aVar2.enW.setDefaultResource(d.f.avatar_channel_poto_defaul160);
            aVar2.enX = (TextView) view.findViewById(d.g.channel_title);
            aVar2.enY = (TextView) view.findViewById(d.g.channel_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        com.baidu.tieba.channel.data.f item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.aRx())) {
                aVar.enW.startLoad(item.aRx(), 10, false);
            }
            if (!TextUtils.isEmpty(item.aRw())) {
                aVar.enX.setText(item.aRw());
            }
            if (!TextUtils.isEmpty(item.getDescription())) {
                aVar.enY.setText(item.getDescription());
            }
        }
        this.enV.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.enV.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        TbImageView enW;
        TextView enX;
        TextView enY;

        private a() {
        }
    }
}
