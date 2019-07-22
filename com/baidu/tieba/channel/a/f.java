package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends BaseAdapter {
    private ChannelListActivity eIo;
    private List<com.baidu.tieba.channel.data.f> mData;

    public f(ChannelListActivity channelListActivity) {
        this.eIo = channelListActivity;
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
    /* renamed from: pN */
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
            view = LayoutInflater.from(this.eIo.getPageContext().getPageActivity()).inflate(R.layout.channel_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.eIp = (TbImageView) view.findViewById(R.id.channel_avatar);
            aVar2.eIp.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
            aVar2.eIp.setDefaultResource(R.drawable.avatar_channel_poto_defaul160);
            aVar2.eIq = (TextView) view.findViewById(R.id.channel_title);
            aVar2.eIr = (TextView) view.findViewById(R.id.channel_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        com.baidu.tieba.channel.data.f item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.baG())) {
                aVar.eIp.startLoad(item.baG(), 10, false);
            }
            if (!TextUtils.isEmpty(item.baF())) {
                aVar.eIq.setText(item.baF());
            }
            if (!TextUtils.isEmpty(item.getDescription())) {
                aVar.eIr.setText(item.getDescription());
            }
        }
        this.eIo.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eIo.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        TbImageView eIp;
        TextView eIq;
        TextView eIr;

        private a() {
        }
    }
}
