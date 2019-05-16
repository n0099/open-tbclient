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
    private ChannelListActivity eDr;
    private List<com.baidu.tieba.channel.data.f> mData;

    public f(ChannelListActivity channelListActivity) {
        this.eDr = channelListActivity;
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
    /* renamed from: px */
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
            view = LayoutInflater.from(this.eDr.getPageContext().getPageActivity()).inflate(R.layout.channel_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.eDs = (TbImageView) view.findViewById(R.id.channel_avatar);
            aVar2.eDs.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
            aVar2.eDs.setDefaultResource(R.drawable.avatar_channel_poto_defaul160);
            aVar2.eDt = (TextView) view.findViewById(R.id.channel_title);
            aVar2.eDu = (TextView) view.findViewById(R.id.channel_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        com.baidu.tieba.channel.data.f item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.aYE())) {
                aVar.eDs.startLoad(item.aYE(), 10, false);
            }
            if (!TextUtils.isEmpty(item.aYD())) {
                aVar.eDt.setText(item.aYD());
            }
            if (!TextUtils.isEmpty(item.getDescription())) {
                aVar.eDu.setText(item.getDescription());
            }
        }
        this.eDr.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eDr.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        TbImageView eDs;
        TextView eDt;
        TextView eDu;

        private a() {
        }
    }
}
