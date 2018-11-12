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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ChannelFansActivity cTn;
    private List<i> mData;

    public b(ChannelFansActivity channelFansActivity) {
        this.cTn = channelFansActivity;
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
    /* renamed from: kq */
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
            view = LayoutInflater.from(this.cTn.getPageContext().getPageActivity()).inflate(e.h.channel_fans_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.cTo = (HeadImageView) view.findViewById(e.g.avatar);
            aVar2.cTo.setAutoChangeStyle(true);
            aVar2.cTo.setIsRound(true);
            aVar2.cTo.setClickable(false);
            aVar2.cTp = (TextView) view.findViewById(e.g.fans_name);
            aVar2.cTq = (TextView) view.findViewById(e.g.fans_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        i item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getPortrait())) {
                aVar.cTo.setTag(null);
                aVar.cTo.setDefaultResource(e.f.img_default_100);
                aVar.cTo.startLoad(item.getPortrait(), 12, false);
                aVar.cTo.invalidate();
            }
            if (!TextUtils.isEmpty(item.getUser_name())) {
                aVar.cTp.setText(item.getUser_name());
            }
            if (!TextUtils.isEmpty(item.getIntro())) {
                aVar.cTq.setText(item.getIntro());
            }
        }
        this.cTn.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cTn.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        HeadImageView cTo;
        TextView cTp;
        TextView cTq;

        private a() {
        }
    }
}
