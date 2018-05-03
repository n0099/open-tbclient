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
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private ChannelListActivity cun;
    private List<com.baidu.tieba.channel.data.f> mData;

    public f(ChannelListActivity channelListActivity) {
        this.cun = channelListActivity;
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
    /* renamed from: iR */
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 != null) {
            aVar = (a) view2.getTag();
        } else {
            view2 = LayoutInflater.from(this.cun.getPageContext().getPageActivity()).inflate(d.i.channel_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.cuo = (TbImageView) view2.findViewById(d.g.channel_avatar);
            aVar2.cuo.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
            aVar2.cuo.setDefaultResource(d.f.avatar_channel_poto_defaul160);
            aVar2.cup = (TextView) view2.findViewById(d.g.channel_title);
            aVar2.cuq = (TextView) view2.findViewById(d.g.channel_intro);
            view2.setTag(aVar2);
            aVar = aVar2;
        }
        com.baidu.tieba.channel.data.f item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.ago())) {
                aVar.cuo.startLoad(item.ago(), 10, false);
            }
            if (!TextUtils.isEmpty(item.agn())) {
                aVar.cup.setText(item.agn());
            }
            if (!TextUtils.isEmpty(item.getDescription())) {
                aVar.cuq.setText(item.getDescription());
            }
        }
        this.cun.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cun.getLayoutMode().u(view2);
        return view2;
    }

    /* loaded from: classes3.dex */
    private class a {
        TbImageView cuo;
        TextView cup;
        TextView cuq;

        private a() {
        }
    }
}
