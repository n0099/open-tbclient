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
    private ChannelFansActivity cuY;
    private List<i> mData;

    public b(ChannelFansActivity channelFansActivity) {
        this.cuY = channelFansActivity;
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
    /* renamed from: iP */
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 != null) {
            aVar = (a) view2.getTag();
        } else {
            view2 = LayoutInflater.from(this.cuY.getPageContext().getPageActivity()).inflate(d.i.channel_fans_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.cuZ = (HeadImageView) view2.findViewById(d.g.avatar);
            aVar2.cuZ.setAutoChangeStyle(true);
            aVar2.cuZ.setIsRound(true);
            aVar2.cuZ.setClickable(false);
            aVar2.cva = (TextView) view2.findViewById(d.g.fans_name);
            aVar2.cvb = (TextView) view2.findViewById(d.g.fans_intro);
            view2.setTag(aVar2);
            aVar = aVar2;
        }
        i item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getPortrait())) {
                aVar.cuZ.setTag(null);
                aVar.cuZ.setDefaultResource(d.f.img_default_100);
                aVar.cuZ.startLoad(item.getPortrait(), 12, false);
                aVar.cuZ.invalidate();
            }
            if (!TextUtils.isEmpty(item.getUser_name())) {
                aVar.cva.setText(item.getUser_name());
            }
            if (!TextUtils.isEmpty(item.getIntro())) {
                aVar.cvb.setText(item.getIntro());
            }
        }
        this.cuY.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cuY.getLayoutMode().u(view2);
        return view2;
    }

    /* loaded from: classes3.dex */
    private class a {
        HeadImageView cuZ;
        TextView cva;
        TextView cvb;

        private a() {
        }
    }
}
