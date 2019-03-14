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
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private ChannelFansActivity eny;
    private List<i> mData;

    public b(ChannelFansActivity channelFansActivity) {
        this.eny = channelFansActivity;
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
    /* renamed from: ow */
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
            view = LayoutInflater.from(this.eny.getPageContext().getPageActivity()).inflate(d.h.channel_fans_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.enz = (HeadImageView) view.findViewById(d.g.avatar);
            aVar2.enz.setAutoChangeStyle(true);
            aVar2.enz.setIsRound(true);
            aVar2.enz.setClickable(false);
            aVar2.enA = (TextView) view.findViewById(d.g.fans_name);
            aVar2.enB = (TextView) view.findViewById(d.g.fans_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        i item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getPortrait())) {
                aVar.enz.setTag(null);
                aVar.enz.setDefaultResource(d.f.img_default_100);
                aVar.enz.startLoad(item.getPortrait(), 12, false);
                aVar.enz.invalidate();
            }
            if (!TextUtils.isEmpty(item.getUser_name())) {
                aVar.enA.setText(item.getUser_name());
            }
            if (!TextUtils.isEmpty(item.getIntro())) {
                aVar.enB.setText(item.getIntro());
            }
        }
        this.eny.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eny.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView enA;
        TextView enB;
        HeadImageView enz;

        private a() {
        }
    }
}
