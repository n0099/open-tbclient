package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.data.i;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ChannelFansActivity cDB;
    private List<i> mData;

    public b(ChannelFansActivity channelFansActivity) {
        this.cDB = channelFansActivity;
    }

    public void setData(List<i> list) {
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
    public i getItem(int i) {
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
            view = LayoutInflater.from(this.cDB.getPageContext().getPageActivity()).inflate(d.i.channel_fans_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.cDC = (HeadImageView) view.findViewById(d.g.avatar);
            aVar2.cDC.setAutoChangeStyle(true);
            aVar2.cDC.setIsRound(true);
            aVar2.cDC.setClickable(false);
            aVar2.cDD = (TextView) view.findViewById(d.g.fans_name);
            aVar2.cDE = (TextView) view.findViewById(d.g.fans_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        i item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getPortrait())) {
                aVar.cDC.setTag(null);
                aVar.cDC.setDefaultResource(d.f.img_default_100);
                aVar.cDC.startLoad(item.getPortrait(), 12, false);
                aVar.cDC.invalidate();
            }
            if (!TextUtils.isEmpty(item.getUser_name())) {
                aVar.cDD.setText(item.getUser_name());
            }
            if (!TextUtils.isEmpty(item.getIntro())) {
                aVar.cDE.setText(item.getIntro());
            }
        }
        this.cDB.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cDB.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        HeadImageView cDC;
        TextView cDD;
        TextView cDE;

        private a() {
        }
    }
}
