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
    private ChannelListActivity eKe;
    private List<com.baidu.tieba.channel.data.f> mData;

    public f(ChannelListActivity channelListActivity) {
        this.eKe = channelListActivity;
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
    /* renamed from: pS */
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
            view = LayoutInflater.from(this.eKe.getPageContext().getPageActivity()).inflate(R.layout.channel_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.eKf = (TbImageView) view.findViewById(R.id.channel_avatar);
            aVar2.eKf.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
            aVar2.eKf.setDefaultResource(R.drawable.avatar_channel_poto_defaul160);
            aVar2.eKg = (TextView) view.findViewById(R.id.channel_title);
            aVar2.eKh = (TextView) view.findViewById(R.id.channel_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        com.baidu.tieba.channel.data.f item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.bbm())) {
                aVar.eKf.startLoad(item.bbm(), 10, false);
            }
            if (!TextUtils.isEmpty(item.bbl())) {
                aVar.eKg.setText(item.bbl());
            }
            if (!TextUtils.isEmpty(item.getDescription())) {
                aVar.eKh.setText(item.getDescription());
            }
        }
        this.eKe.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eKe.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        TbImageView eKf;
        TextView eKg;
        TextView eKh;

        private a() {
        }
    }
}
