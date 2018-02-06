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
    private ChannelListActivity dcH;
    private List<com.baidu.tieba.channel.data.f> mData;

    public f(ChannelListActivity channelListActivity) {
        this.dcH = channelListActivity;
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
    /* renamed from: lH */
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
            view = LayoutInflater.from(this.dcH.getPageContext().getPageActivity()).inflate(d.h.channel_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.dcI = (TbImageView) view.findViewById(d.g.channel_avatar);
            aVar2.dcI.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
            aVar2.dcI.setDefaultResource(d.f.avatar_channel_poto_defaul160);
            aVar2.dcJ = (TextView) view.findViewById(d.g.channel_title);
            aVar2.dcK = (TextView) view.findViewById(d.g.channel_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        com.baidu.tieba.channel.data.f item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.amo())) {
                aVar.dcI.startLoad(item.amo(), 10, false);
            }
            if (!TextUtils.isEmpty(item.amn())) {
                aVar.dcJ.setText(item.amn());
            }
            if (!TextUtils.isEmpty(item.getDescription())) {
                aVar.dcK.setText(item.getDescription());
            }
        }
        this.dcH.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.dcH.getLayoutMode().aM(view);
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TbImageView dcI;
        TextView dcJ;
        TextView dcK;

        private a() {
        }
    }
}
