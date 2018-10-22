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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private ChannelListActivity cSF;
    private List<com.baidu.tieba.channel.data.f> mData;

    public f(ChannelListActivity channelListActivity) {
        this.cSF = channelListActivity;
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
    /* renamed from: jY */
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
            view = LayoutInflater.from(this.cSF.getPageContext().getPageActivity()).inflate(e.h.channel_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.cSG = (TbImageView) view.findViewById(e.g.channel_avatar);
            aVar2.cSG.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
            aVar2.cSG.setDefaultResource(e.f.avatar_channel_poto_defaul160);
            aVar2.cSH = (TextView) view.findViewById(e.g.channel_title);
            aVar2.cSI = (TextView) view.findViewById(e.g.channel_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        com.baidu.tieba.channel.data.f item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.apf())) {
                aVar.cSG.startLoad(item.apf(), 10, false);
            }
            if (!TextUtils.isEmpty(item.ape())) {
                aVar.cSH.setText(item.ape());
            }
            if (!TextUtils.isEmpty(item.getDescription())) {
                aVar.cSI.setText(item.getDescription());
            }
        }
        this.cSF.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cSF.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TbImageView cSG;
        TextView cSH;
        TextView cSI;

        private a() {
        }
    }
}
