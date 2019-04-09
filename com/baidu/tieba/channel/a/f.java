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
    private ChannelListActivity enI;
    private List<com.baidu.tieba.channel.data.f> mData;

    public f(ChannelListActivity channelListActivity) {
        this.enI = channelListActivity;
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
    /* renamed from: ot */
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
            view = LayoutInflater.from(this.enI.getPageContext().getPageActivity()).inflate(d.h.channel_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.enJ = (TbImageView) view.findViewById(d.g.channel_avatar);
            aVar2.enJ.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
            aVar2.enJ.setDefaultResource(d.f.avatar_channel_poto_defaul160);
            aVar2.enK = (TextView) view.findViewById(d.g.channel_title);
            aVar2.enL = (TextView) view.findViewById(d.g.channel_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        com.baidu.tieba.channel.data.f item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.aRv())) {
                aVar.enJ.startLoad(item.aRv(), 10, false);
            }
            if (!TextUtils.isEmpty(item.aRu())) {
                aVar.enK.setText(item.aRu());
            }
            if (!TextUtils.isEmpty(item.getDescription())) {
                aVar.enL.setText(item.getDescription());
            }
        }
        this.enI.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.enI.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        TbImageView enJ;
        TextView enK;
        TextView enL;

        private a() {
        }
    }
}
